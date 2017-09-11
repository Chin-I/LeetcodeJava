/**
 * Created by Gene on 9/11/17.
 */
public class LeetCode_71_SimplifyPath {
        /*
    //C++
    public String simplifyPath(String path) {
        vector<string>   nameVect;
        string name;

        path.push_back('/');
        for(int i=0;i<path.size();i++){
            if(path[i]=='/'){
                if(name.size()==0)continue;
                if(name==".."){		//special case 1：double dot，pop dir
                     if(nameVect.size()>0)nameVect.pop_back();
                }else if(name=="."){//special case 2:singel dot，don`t push
                }else{
                    nameVect.push_back(name);
                }
                name.clear();
            }else{
                name.push_back(path[i]);//record the name
            }
        }

        string result;
        if(nameVect.empty())return "/";
        for(int i=0;i<nameVect.size();i++){
            result.append("/"+nameVect[i]);
        }
        return result;
    }
    */

    //ref Discussion 22%
    public String simplifyPath(String path) {
        if (path == null){
            return null;
        }

        Deque<String> stack = new ArrayDeque<>();//Not Character but String
        Set<String> skip = new HashSet<>(Arrays.asList("",".",".."));//(..)

        for (String s:path.split("/")){
            // if (s == ".." && !stack.isEmpty()){ //String .equal() not ==
            if(s.equals("..") && !stack.isEmpty()){
                stack.pollLast();
            }else if(!skip.contains(s)){
                stack.offerLast(s);
            }
        }

        String ans = "";
        while(!stack.isEmpty()){
            ans = "/" + stack.pollLast() + ans;
        }

        return ans.isEmpty()? "/" : ans; //(..)

        // // for (char ch:path){
        //     if (ch == '/' || 'a' <= ch || ch<= 'z' || 'A'<=ch ||ch<='Z' || '0'<= ch || ch <= '9' ){
        //         stack.offerLast(ch);
        //     }else{
        //     }
    }
}
