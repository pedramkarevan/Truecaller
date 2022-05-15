# Truecaller
<!DOCTYPE html>
<html>


<body class="stackedit">
  <div class="stackedit__html"><h1 id="matching-prefixes">Matching Prefixes</h1>
<p>Given a list of string prefixes of variable length, the assignment is to implement a method that takes a string as a parameter, and returns the longest prefix that matches the input string. A prefix matches if the input string starts with that prefix. The list of prefixes to match should be taken as configuration by your solution. We’ve provided you with sample data that you can use.|  |</p>
<h1 id="sample-data">Sample Data</h1>
<p>The attached file is a list of prefixes, one per line, that can be used to test your implementation. Please use these in your submission, but keep in mind that your solution should work with any list of prefixes.</p>
<h1 id="instructions">Instructions</h1>
<p>Your task is to implement a method with the functionality defined above in either Java or Scala. It is not sufficient for your solution to do a linear scan of the list of prefixes. Feel free to pre-process the list of prefixes as you see fit. What we hope to see in your submitted assignment is an ability to follow the specification and to solve a problem efficiently. We value readability and clear style in your code. Your method should be submitted within a project, not as a single source file. Tests are a great way to show that your implementation works correctly. You may use a readme or comments to document your approach.</p>
<h1 id="solution">Solution</h1>
<p>Main approch is constructing a trie data structure and insert all the input strings which are matched char by char into the trie. Since all descendants of a Trie node have a common prefix of the string associated with that node, Trie (Prefix Tree) is used for this problem.<br>
Tries seems a simple solution, but I have to go through each and every string and add it to a trie. This is memory extensive, unless keep dropping the unmatched chracters in tries.<br>
<strong>insertMatching</strong>(<strong>List</strong>&lt;<strong>String</strong>&gt; <strong>prefixes</strong>, <strong>String</strong> <strong>parameter</strong>)  function is used to insert an individual matching string from the given array of prefixe int trie while  <strong>findLongestPrefix(TrieNode trieNode)</strong>  is used to find  the longest prefix iteratively.</p>
<h1 id="structure-and-configuration">Structure and Configuration</h1>
<p><em><strong>Config Package</strong></em><br>
The file should be inserted into the root of project and file name should be set in application.property.<br>
<strong>propertyConfig(Properties properties)</strong> in <strong>Configuration</strong> class and <strong>getPrefixesFromFileByFirstCharFilter(String fileName, String parameter)</strong> in <strong>PrefixReader</strong> class are used to reading prefixes from sample data file.These services implement two intefces <a href="http://methods.So">methods.So</a> we can easly extend another functionality without need of any changes in these class.For example in this solution I do not considering case-sensitive approach and just return the exact matching <a href="http://prefixes.By">prefixes.By</a> these services we can set case-sensitive parameter to the application property file and filter reading of prefixes based on the parameter.<br>
Regarding to adding charcter to the Trie and evaluting the matching character, I wil filter the prefixes which <strong>are matched at least in the first char as a the first pre proccessing of sample data</strong>.It helps to reduce the range of matching proccess.</p>
<p><em><strong>Solution Package</strong></em><br>
I use this structure to encapsulate the algorithm in a class and configure the <strong>Context</strong> class with an object this class and this is really helpful if we want to extend the solution with many possible variations of an algorithm.</p>
<p><em><strong>Service Package</strong></em><br>
<strong>insertMatching</strong> method get list of the prefixes which are matched with the first character of input parameter and will insert only matching characters based on the length of parameter (matching prefix never be longer than the input itself ) and <strong>findLongestPrefix</strong> method get a Trie that is consist of the whole of matching possible words, so the longest would be the answer.</p>
<p>While we can improve this assignment after another review, I have written the tests, covered the classes and methods with comments, and split more than 4 lines of codes in a method except in some cases for more clarifying.</p>
</div>
</body>

</html>
