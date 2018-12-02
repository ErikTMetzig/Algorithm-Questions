{\rtf1\ansi\ansicpg1252\cocoartf1671\cocoasubrtf100
{\fonttbl\f0\fswiss\fcharset0 Helvetica;}
{\colortbl;\red255\green255\blue255;}
{\*\expandedcolortbl;;}
\margl1440\margr1440\vieww10800\viewh8400\viewkind0
\pard\tx720\tx1440\tx2160\tx2880\tx3600\tx4320\tx5040\tx5760\tx6480\tx7200\tx7920\tx8640\pardirnatural\partightenfactor0

\f0\fs24 \cf0 class LongestPalindromeSubsequence \{\
    \
    public int longestPalindromeSubseq(String s) \{\
    \
        //handle bad input\
        if(s == null || s.length() == 0)\
            return 0;\
        if(s.length() == 1)\
            return 1;\
        \
        int len = s.length();\
        \
        //use dynamic programming - dp[i][j] designates longest \
        //palindromic subsequence front position i to j\
        int dp[][] = new int[len][len];\
        \
        //fill all subsequences of length 1\
        for(int m = 0; m < len; m++)\
            dp[m][m] = 1;\
        \
        //iterate through all possible subsequence lengths\
        int subLen = 2;\
        while(subLen <= len)    \{\
            \
            int front = 0;\
            int back = subLen - 1;\
            \
            //iterate through string with this desired sequence size\
            while(back < len)   \{\
                \
                //if edges are palindromic, length is 2 more than next smallest\
                if(s.charAt(front) == s.charAt(back))\
                    dp[front][back] = dp[front + 1][back - 1] + 2;\
                //otherwise, the same size as next smallst sub\
                else\
                    dp[front][back] = Math.max(dp[front + 1][back], dp[front][back - 1]);\
                \
                //proceed\
                front++;\
                back++;\
            \}\
            \
            subLen++;\
        \}\
        \
        //get our dp value - the whole string\
        return dp[0][len - 1];\
    \}\
\}}