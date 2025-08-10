package com.example.thesyntaxapplication.data

import com.example.thesyntaxapplication.data.model.ProgrammingLanguage
import com.example.thesyntaxapplication.data.model.SyntaxCategory
import com.example.thesyntaxapplication.data.model.SyntaxEntry
import com.example.thesyntaxapplication.data.repository.SyntaxRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DataInitializer @Inject constructor(
    private val repository: SyntaxRepository
) {
    
    fun initializeData() {
        CoroutineScope(Dispatchers.IO).launch {
            // Initialize programming languages
            val languages = listOf(
                ProgrammingLanguage("html", "HTML", "HTML", "#E34F26", "html"),
                ProgrammingLanguage("css", "CSS", "CSS", "#1572B6", "css"),
                ProgrammingLanguage("javascript", "JavaScript", "JavaScript", "#F7DF1E", "javascript"),
                ProgrammingLanguage("python", "Python", "Python", "#3776AB", "python"),
                ProgrammingLanguage("java", "Java", "Java", "#ED8B00", "java"),
                ProgrammingLanguage("kotlin", "Kotlin", "Kotlin", "#7F52FF", "kotlin"),
                ProgrammingLanguage("c", "C", "C", "#A8B9CC", "c"),
                ProgrammingLanguage("cpp", "C++", "C++", "#00599C", "cpp")
            )
            repository.insertLanguages(languages)
            
            // Initialize syntax categories
            val categories = listOf(
                SyntaxCategory("variables", "Variables", "Variable declarations and assignments", "code", 1),
                SyntaxCategory("loops", "Loops", "Looping constructs", "loop", 2),
                SyntaxCategory("conditionals", "Conditionals", "Conditional statements", "if", 3),
                SyntaxCategory("functions", "Functions", "Function definitions and calls", "function", 4),
                SyntaxCategory("classes", "Classes", "Class definitions and inheritance", "class", 5),
                SyntaxCategory("strings", "Strings", "String manipulation", "text", 6),
                SyntaxCategory("arrays", "Arrays", "Array operations", "list", 7),
                SyntaxCategory("objects", "Objects", "Object-oriented features", "object", 8)
            )
            repository.insertCategories(categories)
            
            // Initialize syntax entries
            val entries = mutableListOf<SyntaxEntry>()
            
            // HTML entries
            entries.addAll(createHtmlEntries())
            
            // CSS entries
            entries.addAll(createCssEntries())
            
            // JavaScript entries
            entries.addAll(createJavaScriptEntries())
            
            // Python entries
            entries.addAll(createPythonEntries())
            
            // Java entries
            entries.addAll(createJavaEntries())
            
            // Kotlin entries
            entries.addAll(createKotlinEntries())
            
            // C entries
            entries.addAll(createCEntries())
            
            // C++ entries
            entries.addAll(createCppEntries())
            
            repository.insertEntries(entries)
        }
    }
    
    private fun createHtmlEntries(): List<SyntaxEntry> = listOf(
        SyntaxEntry(
            id = "html-basic-structure",
            languageId = "html",
            categoryId = "classes",
            title = "Basic HTML Structure",
            description = "Basic HTML document structure with DOCTYPE, html, head, and body tags",
            codeSnippet = "<!DOCTYPE html>\n<html>\n<head>\n    <title>Page Title</title>\n</head>\n<body>\n    <h1>Hello World</h1>\n</body>\n</html>",
            example = "Standard HTML5 document structure",
            keywords = "html structure doctype head body"
        ),
        SyntaxEntry(
            id = "html-heading",
            languageId = "html",
            categoryId = "strings",
            title = "HTML Headings",
            description = "Six levels of headings from h1 to h6",
            codeSnippet = "<h1>Heading 1</h1>\n<h2>Heading 2</h2>\n<h3>Heading 3</h3>",
            example = "Use headings to structure your content hierarchically",
            keywords = "heading h1 h2 h3 h4 h5 h6"
        ),
        SyntaxEntry(
            id = "html-paragraph",
            languageId = "html",
            categoryId = "strings",
            title = "HTML Paragraphs",
            description = "Paragraph element for text content",
            codeSnippet = "<p>This is a paragraph of text.</p>",
            example = "Use paragraphs to group related text content",
            keywords = "paragraph p text content"
        ),
        SyntaxEntry(
            id = "html-links",
            languageId = "html",
            categoryId = "strings",
            title = "HTML Links",
            description = "Create hyperlinks with anchor tags",
            codeSnippet = "<a href=\"https://example.com\">Visit Example</a>\n<a href=\"#section\">Jump to Section</a>",
            example = "Links can point to external URLs or internal page sections",
            keywords = "link anchor href a tag"
        ),
        SyntaxEntry(
            id = "html-images",
            languageId = "html",
            categoryId = "strings",
            title = "HTML Images",
            description = "Display images with img tag",
            codeSnippet = "<img src=\"image.jpg\" alt=\"Description\" width=\"300\" height=\"200\">",
            example = "Always include alt text for accessibility",
            keywords = "image img src alt width height"
        ),
        SyntaxEntry(
            id = "html-lists",
            languageId = "html",
            categoryId = "arrays",
            title = "HTML Lists",
            description = "Ordered and unordered lists",
            codeSnippet = "<ul>\n    <li>Item 1</li>\n    <li>Item 2</li>\n</ul>\n\n<ol>\n    <li>First</li>\n    <li>Second</li>\n</ol>",
            example = "Use ul for unordered lists, ol for ordered lists",
            keywords = "list ul ol li unordered ordered"
        ),
        SyntaxEntry(
            id = "html-forms",
            languageId = "html",
            categoryId = "objects",
            title = "HTML Forms",
            description = "Create forms for user input",
            codeSnippet = "<form action=\"/submit\" method=\"post\">\n    <input type=\"text\" name=\"username\" placeholder=\"Username\">\n    <input type=\"password\" name=\"password\" placeholder=\"Password\">\n    <button type=\"submit\">Submit</button>\n</form>",
            example = "Forms collect user data and send it to a server",
            keywords = "form input button submit method action"
        ),
        SyntaxEntry(
            id = "html-div-span",
            languageId = "html",
            categoryId = "objects",
            title = "HTML Div and Span",
            description = "Container elements for grouping content",
            codeSnippet = "<div class=\"container\">\n    <span class=\"highlight\">Important text</span>\n    <p>Regular paragraph</p>\n</div>",
            example = "Use div for block-level containers, span for inline elements",
            keywords = "div span container block inline"
        )
    )
    
    private fun createCssEntries(): List<SyntaxEntry> = listOf(
        SyntaxEntry(
            id = "css-selector",
            languageId = "css",
            categoryId = "variables",
            title = "CSS Selectors",
            description = "Different types of CSS selectors",
            codeSnippet = "/* Element selector */\nelement { }\n\n/* Class selector */\n.class { }\n\n/* ID selector */\n#id { }",
            example = "Use selectors to target specific HTML elements",
            keywords = "selector class id element css"
        ),
        SyntaxEntry(
            id = "css-properties",
            languageId = "css",
            categoryId = "variables",
            title = "CSS Properties",
            description = "Common CSS properties for styling",
            codeSnippet = "element {\n    color: #333;\n    background-color: white;\n    font-size: 16px;\n    margin: 10px;\n    padding: 5px;\n}",
            example = "Apply multiple properties to style elements",
            keywords = "css properties color background font margin padding"
        ),
        SyntaxEntry(
            id = "css-box-model",
            languageId = "css",
            categoryId = "objects",
            title = "CSS Box Model",
            description = "Understanding margin, border, padding, and content",
            codeSnippet = ".box {\n    margin: 10px;\n    border: 2px solid black;\n    padding: 20px;\n    width: 200px;\n    height: 100px;\n}",
            example = "The box model controls element spacing and sizing",
            keywords = "box model margin border padding width height"
        ),
        SyntaxEntry(
            id = "css-flexbox",
            languageId = "css",
            categoryId = "objects",
            title = "CSS Flexbox",
            description = "Flexible box layout for responsive design",
            codeSnippet = ".container {\n    display: flex;\n    justify-content: center;\n    align-items: center;\n    flex-direction: row;\n}",
            example = "Flexbox makes it easy to create flexible layouts",
            keywords = "flexbox flex justify-content align-items flex-direction"
        ),
        SyntaxEntry(
            id = "css-grid",
            languageId = "css",
            categoryId = "objects",
            title = "CSS Grid",
            description = "Two-dimensional layout system",
            codeSnippet = ".grid {\n    display: grid;\n    grid-template-columns: 1fr 1fr 1fr;\n    grid-gap: 20px;\n}",
            example = "CSS Grid is perfect for complex layouts",
            keywords = "grid display grid-template-columns grid-gap"
        ),
        SyntaxEntry(
            id = "css-media-queries",
            languageId = "css",
            categoryId = "conditionals",
            title = "CSS Media Queries",
            description = "Responsive design with media queries",
            codeSnippet = "@media (max-width: 768px) {\n    .container {\n        flex-direction: column;\n    }\n}",
            example = "Media queries adapt styles for different screen sizes",
            keywords = "media query responsive mobile tablet"
        ),
        SyntaxEntry(
            id = "css-pseudo-classes",
            languageId = "css",
            categoryId = "conditionals",
            title = "CSS Pseudo-classes",
            description = "Style elements based on their state",
            codeSnippet = "button:hover {\n    background-color: blue;\n}\n\ninput:focus {\n    border-color: green;\n}",
            example = "Pseudo-classes respond to user interactions",
            keywords = "pseudo-class hover focus active visited"
        )
    )
    
    private fun createJavaScriptEntries(): List<SyntaxEntry> = listOf(
        SyntaxEntry(
            id = "js-variable",
            languageId = "javascript",
            categoryId = "variables",
            title = "Variable Declaration",
            description = "Different ways to declare variables in JavaScript",
            codeSnippet = "let variable = 'value';\nconst constant = 'value';\nvar oldWay = 'value';",
            example = "Use let for variables that can change, const for constants",
            keywords = "variable let const var declaration"
        ),
        SyntaxEntry(
            id = "js-function",
            languageId = "javascript",
            categoryId = "functions",
            title = "Function Declaration",
            description = "Different ways to declare functions",
            codeSnippet = "function myFunction() {\n    return 'Hello';\n}\n\nconst arrowFunction = () => {\n    return 'Hello';\n};",
            example = "Functions can be declared traditionally or as arrow functions",
            keywords = "function arrow function declaration"
        ),
        SyntaxEntry(
            id = "js-loop",
            languageId = "javascript",
            categoryId = "loops",
            title = "For Loop",
            description = "Different types of for loops",
            codeSnippet = "for (let i = 0; i < 10; i++) {\n    console.log(i);\n}\n\nfor (const item of array) {\n    console.log(item);\n}",
            example = "Use for loops to iterate over data",
            keywords = "for loop iteration array"
        ),
        SyntaxEntry(
            id = "js-conditional",
            languageId = "javascript",
            categoryId = "conditionals",
            title = "Conditional Statements",
            description = "If, else if, and else statements",
            codeSnippet = "if (condition) {\n    // code\n} else if (otherCondition) {\n    // code\n} else {\n    // code\n}",
            example = "Use conditionals to make decisions in your code",
            keywords = "if else conditional statement"
        ),
        SyntaxEntry(
            id = "js-array",
            languageId = "javascript",
            categoryId = "arrays",
            title = "Array Methods",
            description = "Common array manipulation methods",
            codeSnippet = "const arr = [1, 2, 3];\narr.push(4);\narr.pop();\narr.map(x => x * 2);\narr.filter(x => x > 1);",
            example = "Arrays have many built-in methods for manipulation",
            keywords = "array push pop map filter reduce"
        ),
        SyntaxEntry(
            id = "js-object",
            languageId = "javascript",
            categoryId = "objects",
            title = "Object Literals",
            description = "Creating and accessing object properties",
            codeSnippet = "const person = {\n    name: 'John',\n    age: 30,\n    greet() {\n        return `Hello, ${this.name}`;\n    }\n};",
            example = "Objects group related data and functionality",
            keywords = "object literal property method this"
        ),
        SyntaxEntry(
            id = "js-class",
            languageId = "javascript",
            categoryId = "classes",
            title = "ES6 Classes",
            description = "Class syntax for object-oriented programming",
            codeSnippet = "class Person {\n    constructor(name) {\n        this.name = name;\n    }\n    \n    greet() {\n        return `Hello, ${this.name}`;\n    }\n}",
            example = "Classes provide a cleaner syntax for creating objects",
            keywords = "class constructor method extends super"
        ),
        SyntaxEntry(
            id = "js-string",
            languageId = "javascript",
            categoryId = "strings",
            title = "String Methods",
            description = "Common string manipulation methods",
            codeSnippet = "const str = 'Hello World';\nstr.length;\nstr.toUpperCase();\nstr.toLowerCase();\nstr.includes('World');",
            example = "Strings have many useful built-in methods",
            keywords = "string length toUpperCase toLowerCase includes"
        )
    )
    
    private fun createPythonEntries(): List<SyntaxEntry> = listOf(
        SyntaxEntry(
            id = "python-variable",
            languageId = "python",
            categoryId = "variables",
            title = "Variable Assignment",
            description = "Variable assignment in Python",
            codeSnippet = "variable = 'value'\nnumber = 42\nis_true = True",
            example = "Python uses dynamic typing",
            keywords = "variable assignment python dynamic typing"
        ),
        SyntaxEntry(
            id = "python-function",
            languageId = "python",
            categoryId = "functions",
            title = "Function Definition",
            description = "Define functions in Python",
            codeSnippet = "def my_function(param):\n    return param * 2\n\nresult = my_function(5)",
            example = "Functions are defined using the def keyword",
            keywords = "function def return parameter"
        ),
        SyntaxEntry(
            id = "python-loop",
            languageId = "python",
            categoryId = "loops",
            title = "For Loop",
            description = "For loops in Python",
            codeSnippet = "for item in items:\n    print(item)\n\nfor i in range(10):\n    print(i)",
            example = "Python for loops iterate over sequences",
            keywords = "for loop range iteration"
        ),
        SyntaxEntry(
            id = "python-conditional",
            languageId = "python",
            categoryId = "conditionals",
            title = "Conditional Statements",
            description = "If, elif, and else statements",
            codeSnippet = "if condition:\n    # code\nelif other_condition:\n    # code\nelse:\n    # code",
            example = "Use indentation to define code blocks",
            keywords = "if elif else conditional statement"
        ),
        SyntaxEntry(
            id = "python-list",
            languageId = "python",
            categoryId = "arrays",
            title = "List Operations",
            description = "Creating and manipulating lists",
            codeSnippet = "my_list = [1, 2, 3]\nmy_list.append(4)\nmy_list.remove(2)\nmy_list[0] = 10",
            example = "Lists are mutable sequences in Python",
            keywords = "list append remove index slice"
        ),
        SyntaxEntry(
            id = "python-class",
            languageId = "python",
            categoryId = "classes",
            title = "Class Definition",
            description = "Define classes in Python",
            codeSnippet = "class MyClass:\n    def __init__(self, name):\n        self.name = name\n    \n    def greet(self):\n        return f'Hello, {self.name}'",
            example = "Classes are the foundation of OOP in Python",
            keywords = "class __init__ self method"
        ),
        SyntaxEntry(
            id = "python-string",
            languageId = "python",
            categoryId = "strings",
            title = "String Methods",
            description = "Common string operations",
            codeSnippet = "text = 'Hello World'\nlen(text)\ntext.upper()\ntext.lower()\ntext.split()",
            example = "Strings have many built-in methods",
            keywords = "string len upper lower split join"
        ),
        SyntaxEntry(
            id = "python-dict",
            languageId = "python",
            categoryId = "objects",
            title = "Dictionary",
            description = "Key-value pairs in Python",
            codeSnippet = "person = {\n    'name': 'John',\n    'age': 30\n}\nperson['name']\nperson.get('age', 0)",
            example = "Dictionaries store key-value pairs",
            keywords = "dictionary dict key value get"
        )
    )
    
    private fun createJavaEntries(): List<SyntaxEntry> = listOf(
        SyntaxEntry(
            id = "java-variable",
            languageId = "java",
            categoryId = "variables",
            title = "Variable Declaration",
            description = "Variable declaration in Java",
            codeSnippet = "String text = \"Hello\";\nint number = 42;\nboolean flag = true;",
            example = "Java requires explicit type declaration",
            keywords = "variable declaration type string int boolean"
        ),
        SyntaxEntry(
            id = "java-class",
            languageId = "java",
            categoryId = "classes",
            title = "Class Definition",
            description = "Define a class in Java",
            codeSnippet = "public class MyClass {\n    private String name;\n    \n    public MyClass(String name) {\n        this.name = name;\n    }\n}",
            example = "Classes are the foundation of object-oriented programming in Java",
            keywords = "class public private constructor"
        ),
        SyntaxEntry(
            id = "java-method",
            languageId = "java",
            categoryId = "functions",
            title = "Method Definition",
            description = "Define methods in Java classes",
            codeSnippet = "public String getName() {\n    return this.name;\n}\n\npublic void setName(String name) {\n    this.name = name;\n}",
            example = "Methods define behavior in Java classes",
            keywords = "method public private void return"
        ),
        SyntaxEntry(
            id = "java-loop",
            languageId = "java",
            categoryId = "loops",
            title = "For Loop",
            description = "Different types of for loops in Java",
            codeSnippet = "for (int i = 0; i < 10; i++) {\n    System.out.println(i);\n}\n\nfor (String item : items) {\n    System.out.println(item);\n}",
            example = "Use for loops to iterate over data",
            keywords = "for loop iteration enhanced for"
        ),
        SyntaxEntry(
            id = "java-conditional",
            languageId = "java",
            categoryId = "conditionals",
            title = "Conditional Statements",
            description = "If, else if, and else statements",
            codeSnippet = "if (condition) {\n    // code\n} else if (otherCondition) {\n    // code\n} else {\n    // code\n}",
            example = "Use conditionals to make decisions in your code",
            keywords = "if else conditional statement"
        ),
        SyntaxEntry(
            id = "java-array",
            languageId = "java",
            categoryId = "arrays",
            title = "Array Declaration",
            description = "Creating and using arrays in Java",
            codeSnippet = "int[] numbers = {1, 2, 3, 4, 5};\nString[] names = new String[3];\nnames[0] = \"John\";",
            example = "Arrays store fixed-size collections of elements",
            keywords = "array declaration initialization index"
        ),
        SyntaxEntry(
            id = "java-string",
            languageId = "java",
            categoryId = "strings",
            title = "String Methods",
            description = "Common String class methods",
            codeSnippet = "String text = \"Hello World\";\ntext.length();\ntext.toUpperCase();\ntext.toLowerCase();\ntext.contains(\"World\");",
            example = "String class provides many useful methods",
            keywords = "string length toUpperCase toLowerCase contains"
        )
    )
    
    private fun createKotlinEntries(): List<SyntaxEntry> = listOf(
        SyntaxEntry(
            id = "kotlin-variable",
            languageId = "kotlin",
            categoryId = "variables",
            title = "Variable Declaration",
            description = "Variable declaration in Kotlin",
            codeSnippet = "val immutable = \"value\"\nvar mutable = \"value\"\nval number: Int = 42",
            example = "Use val for immutable variables, var for mutable ones",
            keywords = "variable val var immutable mutable"
        ),
        SyntaxEntry(
            id = "kotlin-function",
            languageId = "kotlin",
            categoryId = "functions",
            title = "Function Definition",
            description = "Define functions in Kotlin",
            codeSnippet = "fun myFunction(param: String): String {\n    return param.uppercase()\n}\n\nfun singleExpression(x: Int) = x * 2",
            example = "Kotlin functions can be single-expression or block-bodied",
            keywords = "function fun return parameter"
        ),
        SyntaxEntry(
            id = "kotlin-class",
            languageId = "kotlin",
            categoryId = "classes",
            title = "Class Definition",
            description = "Define classes in Kotlin",
            codeSnippet = "class Person(val name: String) {\n    fun greet() = \"Hello, $name\"\n}\n\nval person = Person(\"John\")",
            example = "Kotlin classes are more concise than Java",
            keywords = "class constructor property method"
        ),
        SyntaxEntry(
            id = "kotlin-loop",
            languageId = "kotlin",
            categoryId = "loops",
            title = "For Loop",
            description = "For loops in Kotlin",
            codeSnippet = "for (i in 0..9) {\n    println(i)\n}\n\nfor (item in items) {\n    println(item)\n}",
            example = "Kotlin for loops use ranges and collections",
            keywords = "for loop range iteration"
        ),
        SyntaxEntry(
            id = "kotlin-conditional",
            languageId = "kotlin",
            categoryId = "conditionals",
            title = "Conditional Statements",
            description = "If expressions and when statements",
            codeSnippet = "val result = if (condition) {\n    \"Yes\"\n} else {\n    \"No\"\n}\n\nwhen (value) {\n    1 -> \"One\"\n    2 -> \"Two\"\n    else -> \"Other\"\n}",
            example = "Kotlin if expressions return values",
            keywords = "if when else conditional expression"
        ),
        SyntaxEntry(
            id = "kotlin-list",
            languageId = "kotlin",
            categoryId = "arrays",
            title = "List Operations",
            description = "Creating and manipulating lists",
            codeSnippet = "val list = listOf(1, 2, 3)\nval mutableList = mutableListOf(1, 2, 3)\nmutableList.add(4)\nlist.map { it * 2 }",
            example = "Kotlin provides both immutable and mutable lists",
            keywords = "list listOf mutableListOf map filter"
        ),
        SyntaxEntry(
            id = "kotlin-string",
            languageId = "kotlin",
            categoryId = "strings",
            title = "String Templates",
            description = "String interpolation in Kotlin",
            codeSnippet = "val name = \"John\"\nval message = \"Hello, $name\"\nval result = \"${name.length} characters\"",
            example = "String templates make string formatting easy",
            keywords = "string template interpolation $"
        ),
        SyntaxEntry(
            id = "kotlin-null",
            languageId = "kotlin",
            categoryId = "conditionals",
            title = "Null Safety",
            description = "Handling null values safely",
            codeSnippet = "val nullable: String? = null\nval safe = nullable?.length\nval default = nullable ?: \"default\"",
            example = "Kotlin's null safety prevents null pointer exceptions",
            keywords = "null safety ? ?. ?:"
        )
    )
    
    private fun createCEntries(): List<SyntaxEntry> = listOf(
        SyntaxEntry(
            id = "c-variable",
            languageId = "c",
            categoryId = "variables",
            title = "Variable Declaration",
            description = "Variable declaration in C",
            codeSnippet = "int number = 42;\nchar letter = 'A';\nfloat decimal = 3.14;",
            example = "C requires explicit type declaration",
            keywords = "variable declaration int char float"
        ),
        SyntaxEntry(
            id = "c-function",
            languageId = "c",
            categoryId = "functions",
            title = "Function Definition",
            description = "Define functions in C",
            codeSnippet = "int add(int a, int b) {\n    return a + b;\n}",
            example = "C functions must specify return type and parameter types",
            keywords = "function return parameter type"
        ),
        SyntaxEntry(
            id = "c-pointer",
            languageId = "c",
            categoryId = "variables",
            title = "Pointers",
            description = "Working with pointers in C",
            codeSnippet = "int value = 42;\nint *ptr = &value;\n*ptr = 100;",
            example = "Pointers store memory addresses",
            keywords = "pointer * & dereference address"
        ),
        SyntaxEntry(
            id = "c-array",
            languageId = "c",
            categoryId = "arrays",
            title = "Array Declaration",
            description = "Creating and using arrays in C",
            codeSnippet = "int numbers[5] = {1, 2, 3, 4, 5};\nchar string[] = \"Hello\";\nnumbers[0] = 10;",
            example = "Arrays in C are fixed-size collections",
            keywords = "array declaration initialization index"
        ),
        SyntaxEntry(
            id = "c-struct",
            languageId = "c",
            categoryId = "objects",
            title = "Struct Definition",
            description = "Define structures in C",
            codeSnippet = "struct Person {\n    char name[50];\n    int age;\n};\n\nstruct Person person = {\"John\", 30};",
            example = "Structs group related data together",
            keywords = "struct definition member access"
        ),
        SyntaxEntry(
            id = "c-loop",
            languageId = "c",
            categoryId = "loops",
            title = "For Loop",
            description = "For loops in C",
            codeSnippet = "for (int i = 0; i < 10; i++) {\n    printf(\"%d\\n\", i);\n}",
            example = "For loops are the most common loop in C",
            keywords = "for loop iteration increment"
        ),
        SyntaxEntry(
            id = "c-conditional",
            languageId = "c",
            categoryId = "conditionals",
            title = "Conditional Statements",
            description = "If, else if, and else statements",
            codeSnippet = "if (condition) {\n    // code\n} else if (otherCondition) {\n    // code\n} else {\n    // code\n}",
            example = "Use conditionals to make decisions in your code",
            keywords = "if else conditional statement"
        ),
        SyntaxEntry(
            id = "c-string",
            languageId = "c",
            categoryId = "strings",
            title = "String Functions",
            description = "Common string manipulation functions",
            codeSnippet = "#include <string.h>\nchar str[] = \"Hello\";\nstrlen(str);\nstrcpy(dest, src);\nstrcat(str1, str2);",
            example = "C strings are character arrays with null termination",
            keywords = "string strlen strcpy strcat null"
        )
    )
    
    private fun createCppEntries(): List<SyntaxEntry> = listOf(
        SyntaxEntry(
            id = "cpp-class",
            languageId = "cpp",
            categoryId = "classes",
            title = "Class Definition",
            description = "Define a class in C++",
            codeSnippet = "class MyClass {\nprivate:\n    string name;\npublic:\n    MyClass(string n) : name(n) {}\n    string getName() { return name; }\n};",
            example = "C++ classes support access modifiers and constructors",
            keywords = "class private public constructor"
        ),
        SyntaxEntry(
            id = "cpp-template",
            languageId = "cpp",
            categoryId = "functions",
            title = "Template Function",
            description = "Generic programming with templates",
            codeSnippet = "template<typename T>\nT max(T a, T b) {\n    return (a > b) ? a : b;\n}",
            example = "Templates allow generic programming in C++",
            keywords = "template typename generic programming"
        ),
        SyntaxEntry(
            id = "cpp-variable",
            languageId = "cpp",
            categoryId = "variables",
            title = "Variable Declaration",
            description = "Variable declaration in C++",
            codeSnippet = "int number = 42;\nstring text = \"Hello\";\nbool flag = true;\nconst double PI = 3.14159;",
            example = "C++ supports various data types and const qualifiers",
            keywords = "variable declaration int string bool const"
        ),
        SyntaxEntry(
            id = "cpp-vector",
            languageId = "cpp",
            categoryId = "arrays",
            title = "Vector Container",
            description = "Dynamic array container from STL",
            codeSnippet = "#include <vector>\nvector<int> numbers = {1, 2, 3};\nnumbers.push_back(4);\nnumbers.size();\nnumbers[0] = 10;",
            example = "Vectors are dynamic arrays that can grow and shrink",
            keywords = "vector push_back size index stl"
        ),
        SyntaxEntry(
            id = "cpp-function",
            languageId = "cpp",
            categoryId = "functions",
            title = "Function Definition",
            description = "Define functions in C++",
            codeSnippet = "int add(int a, int b) {\n    return a + b;\n}\n\nvoid printMessage(string msg) {\n    cout << msg << endl;\n}",
            example = "C++ functions can return values or be void",
            keywords = "function return void parameter"
        ),
        SyntaxEntry(
            id = "cpp-loop",
            languageId = "cpp",
            categoryId = "loops",
            title = "For Loop",
            description = "Different types of for loops in C++",
            codeSnippet = "for (int i = 0; i < 10; i++) {\n    cout << i << endl;\n}\n\nfor (const auto& item : container) {\n    cout << item << endl;\n}",
            example = "C++11 introduced range-based for loops",
            keywords = "for loop iteration range-based auto"
        ),
        SyntaxEntry(
            id = "cpp-conditional",
            languageId = "cpp",
            categoryId = "conditionals",
            title = "Conditional Statements",
            description = "If, else if, and else statements",
            codeSnippet = "if (condition) {\n    // code\n} else if (otherCondition) {\n    // code\n} else {\n    // code\n}",
            example = "Use conditionals to make decisions in your code",
            keywords = "if else conditional statement"
        ),
        SyntaxEntry(
            id = "cpp-string",
            languageId = "cpp",
            categoryId = "strings",
            title = "String Operations",
            description = "Working with std::string",
            codeSnippet = "#include <string>\nstring text = \"Hello World\";\ntext.length();\ntext.substr(0, 5);\ntext.find(\"World\");",
            example = "std::string provides many useful methods",
            keywords = "string length substr find stl"
        ),
        SyntaxEntry(
            id = "cpp-namespace",
            languageId = "cpp",
            categoryId = "objects",
            title = "Namespaces",
            description = "Organizing code with namespaces",
            codeSnippet = "namespace MyNamespace {\n    void myFunction() {\n        // code\n    }\n}\n\nusing namespace std;",
            example = "Namespaces prevent naming conflicts",
            keywords = "namespace using scope resolution"
        )
    )
}
