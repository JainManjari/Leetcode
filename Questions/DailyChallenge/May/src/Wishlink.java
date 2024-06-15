/*

1) N number of users
2) any user can share expense btw n-1 people
3) equal split type , extract split type , percentage split type
4) show the balance of user 1 => {user1 owns to money to how many users and how many users own money to user1}


 */

/*





 enum SpliType {
   EQUAL,
   EXTACT,
   PERCENTAGE
 }

class User {
   String id;
   String name;
   String email;
}


user 1 owns 100 to user 2
user 1 owns 10 to user 3

class Balance
{
        String id;
        int amount;
        String userWhoPaidId;
        String userWhoOwnedId;
}

class SplitExpense {
    String id;
    // it will be owned user
    String userId; // user1
    List<Balance> balances;  {100:user 2, 10:user3}
}


// split 100 btw user1, user2 and user3, user4
// split of 100 , user2 , user1, user3, user4
// who paid the amount ? user1

// exp1
{amount:25,
userWhoPaidId=user1
userWhoOwnedId = user2
}



// exp 2
{amount:25,
userWhoPaidId=user2
userWhoOwnedId = user1
}

// Balance
select userWhoOwnedId, amount from balance where userWhoPaidId="user1";
user2, 15  //+


select userWhoPaidId, amount from balance where userWhoOwnedId="user1";
// -
user3, 50
user2, 20

// merge
Map<userId, Integer> map =








user2 owns to user1  => 25
user1 own to user2  => -10
user1 own to user3  => -50


user 1=> -15 to user2
         -50 to user3











{
{"user2",{"25":"user1}}
{"user3, {"25":"user1"}}
{"user4, {"25":"user1"}}
}


{
{"user1",{"25":"user2}}
{"user3, {"25":"user2"}}
{"user4, {"25":"user2"}}
}


class Expense {

  String id;
  List<SplitExpense> splitExpenses;

}






 */

import java.util.*;
import java.util.stream.Collectors;

class User {
    String id;
    String name;
}


class Balance {
    String id;
    int amount;
    String userWhoPaidId;
    String userWhoOwnit;
}


//class SplitExpense {
//    String id;
//
//}

enum SplitType {
    EQUAL,
    EXTACT,
    PERCENTAGE;
}

class Expense {
    String id;
    List<Balance> balances;
}

class EqualExpense extends  Expense {

}

class ExpenseFactory {
    public static ExpenseManager getExpenseManager(SplitType splitType) {

        return new EqualExpenseManager();
    }

}



interface ExpenseManager {

    public Expense addExpense(int amount, String whoPaidIt, List<String> userIds);

}


class EqualExpenseManager implements ExpenseManager {
    public Expense addExpense(int amount, String whoPaidIt, List<String> userIds) {

        Expense expense = new Expense();
        expense.balances = new ArrayList<>();

        for(String user:userIds) {
            Balance balance = new Balance();
            balance.amount = amount/(userIds.size()+1);
            balance.userWhoOwnit = user;
            balance.userWhoPaidId = whoPaidIt;
            expense.balances.add(balance);
        }

        return expense;

    }
}


class BalanceManager {

    List<Balance> balances;

    public BalanceManager(List<Balance> balances) {
        this.balances = balances;
    }

    public List<Balance> getOwnedBalances(String userId) {
        return balances.stream().filter(balance -> balance.userWhoOwnit.equals(userId)).collect(Collectors.toList());
    }

    public List<Balance> getPaidBalances(String userId) {
        return balances.stream().filter(balance -> balance.userWhoPaidId.equals(userId)).collect(Collectors.toList());
    }


    public Map<String, Integer> getBalances(String userId) {

        Map<String, Integer> map = new HashMap<>();

        // -ve money
        List<Balance> ownedBalances = getOwnedBalances(userId);

        for(Balance balance:ownedBalances) {
            map.put(balance.userWhoPaidId, map.getOrDefault(balance.userWhoPaidId, 0) -balance.amount);
        }


        // +ive money
        List<Balance> paidBalances = getPaidBalances(userId);

        for(Balance balance:paidBalances) {
            map.put(balance.userWhoOwnit, map.getOrDefault(balance.userWhoOwnit, 0) + balance.amount);
        }

        return map;


    }

}





public class Wishlink {

    public static void main(String[] args) {

        EqualExpenseManager expenseManager = new EqualExpenseManager();

        List<String> users = new ArrayList<>();
        users.add("user2");
        users.add("user3");
        users.add("user4");

        Expense expense = expenseManager.addExpense(100, "user1", users);

        users = new ArrayList<>();
        users.add("user1");
        users.add("user3");
        users.add("user4");

        Expense expense1 = expenseManager.addExpense(100, "user2", users);

        List<Balance> balances = new ArrayList<>();

        balances.addAll(expense.balances);
        balances.addAll(expense1.balances);

        BalanceManager balanceManager = new BalanceManager(balances);

        System.out.println(balanceManager.getBalances("user1"));



    }
}
