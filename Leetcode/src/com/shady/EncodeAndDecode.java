package com.shady;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//271. Encode and Decode Strings
//Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.
//
//        Machine 1 (sender) has the function:
//
//        string encode(vector<string> strs) {
//        // ... your code
//        return encoded_string;
//        }
//        Machine 2 (receiver) has the function:
//        vector<string> decode(string s) {
//        //... your code
//        return strs;
//        }
//        So Machine 1 does:
//
//        string encoded_string = encode(strs);
//        and Machine 2 does:
//
//        vector<string> strs2 = decode(encoded_string);
//        strs2 in Machine 2 should be the same as strs in Machine 1.
//
//        Implement the encode and decode methods.
//
//        You are not allowed to solve the problem using any serialize methods (such as eval).
//
//
//
//        Example 1:
//
//        Input: dummy_input = ["Hello","World"]
//        Output: ["Hello","World"]
//        Explanation:
//        Machine 1:
//        Codec encoder = new Codec();
//        String msg = encoder.encode(strs);
//        Machine 1 ---msg---> Machine 2
//
//        Machine 2:
//        Codec decoder = new Codec();
//        String[] strs = decoder.decode(msg);
//        Example 2:
//
//        Input: dummy_input = [""]
//        Output: [""]
public class EncodeAndDecode {
    //Solution 1
    //Complexity Analysis
    //
    //Time complexity : O(N) both for encode and decode, where N is a number of strings in the input array.
    //
    //Space complexity : O(1) for encode to keep the output, since the output is one string. {O}(N)O(N) for decode keep the output, since the output is an array of strings.
    public class Codec {

        // Encodes a list of strings to a single string.
        public String encode(List<String> strs) {

            if(strs.size() == 0){//输入的字符串list为空
                 return null;
            }
            StringBuilder stringBuilder = new StringBuilder();
            String s = Character.toString((char) 257);//s
            for(String s1 : strs){

                stringBuilder.append(s1);
                stringBuilder.append(s);
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);


            return stringBuilder.toString();


        }

        // Decodes a single string to a list of strings.
        public List<String> decode(String s) {
            if(s == null){
                return new ArrayList<>();
            }
            return Arrays.asList(s.split(Character.toString((char)257), -1));
        }
    }

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
}
