#Java Exercises

##Anagram Counter

An anagram is a word where when you rearrange the letters to get another word.
Say you had a list of words and you wanted to count the number of unique anagrams there are. For example:

cat act
rat tar art
face cafe
trap rapt part tarp
univision
      
Create a count array that counts all the unique anagrams in the words array.
The letters in the keys in the count array can be in any order. The same word can appear twice in the words array.

$words = array('cat', 'cat', 'rat', 'tar', 'art', 'trap', 'rapt', 'univision', 'act', 'part', 'trap', 'part', 'tarp', 'rat', 'face', 'cafe');
$count = array( 'act' => 3,
        'art' => 4,
        'part' => 6,
        'face' => 2,
        'univision' => 1 );
        
##Matrix Rotator

Rotate a matrix of characters (so no vector multiplication can be done) 90 degrees.

a b c      g d a
d e f  =>  h e b
g h i      i f c

$m = array();

$m[0] = {'a', 'b', 'c'};
$m[1] = {'d', 'e', 'f'};
$m[2] = {'g', 'h', 'i'};

## Triple Double

Given two integers, tell if the first contains a subsequence of three consecutive digits equal between each other. Also tell if the second contains a subsequence of two consecutive digits equal between each other.

