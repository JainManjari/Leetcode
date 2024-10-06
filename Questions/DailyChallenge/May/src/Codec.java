import java.util.HashMap;
import java.util.Map;

public class Codec {

    Map<String, String> map = new HashMap<>();
    char a[]={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',
            'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z',
            '0','1','2','3','4','5','6','7','8','9'};

// Encodes a URL to a shortened URL.
public String encode(String longUrl) {
    String ans = "";
    for(int i=0;i<7;i++) {
        int randomNum = 0 + (int)(Math.random()*7);
        ans+=a[i];
    }
    map.put(ans, longUrl);
    return ans;
}

// Decodes a shortened URL to its original URL.
public String decode(String shortUrl) {
    return map.get(shortUrl);
}
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));