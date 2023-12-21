<h1>Examples</h1>
For all exercises, test things out using the following arrays:

```java
int[] nums = {7,13,5,12,7,10};
int randomLength = (int)(Math.random()*20)
int[] nums2 = new int[randomLength];
for(int i=0; i<nums2.length; i++){        
    nums2[i] = (int)(Math.random()*50);   
}                                         
int[] nums3 = {};
```

Put these arrays inside of your main method, and then attempt to accomplish the following tasks using this array in a main method. You can print out the array by writing a for-loop that prints out each element.

<h2>Handling an empty array</h2>
Sometimes, arrays of length 0 can be troublesome and make your code not work. To make things easier, you can always write an if-statement at the very beginning of your method and have this if-statement return the appropriate value for what you want to happen for a length 0 array.

<h2>Run for-loop for an array when you don't know the length of the array in advance</h2>

```java
for(int i=0; i<nums.length; i++){
    //code                            
}                                
```

<h2>Overwrite all Even Elements with 0</h2>

```java
for(int i=0; i<nums.length; i++){
    if(nums[i]%2==0){
        nums[i]=0;
    }
}
```

<h2>Look forward one element</h2>
Why doesn't the code below work?

```java
for(int i=0; i<nums.length; i++){                 
    System.out.print(nums[i]+", "+nums[i+1]+", ");
}
``` 
<h3>A fix</h3>
Stop the for-loop one iteration sooner.

```java
for(int i=0; i<nums.length-1; i++){               
    System.out.print(nums[i]+", "+nums[i+1]+", ");
}
```
<h3>Another fix</h3>
Break out of the for-loop when i+1 is a value greater than the final index in the array.

```java
for(int i=0; i<nums.length; i++){                 
    if(i+1==nums.length){                         
        break;                                    
    }                                             
    System.out.print(nums[i]+", "+nums[i+1]+", ");
}                                                 
```
<h2>Look backwards an element</h2>
This works similarly to looking forward an element. Why does the code below not work?

```java
for(int i=0; i<nums.length; i++){                   
    System.out.print(nums[i-1]+", "+nums[i]+", ");  
}                                                    
```
<h3>A fix</h3>
Start the for-loop one iteration ahead.

```java
for(int i=1; i<nums.length; i++){
    System.out.print(nums[i-1]+", "+nums[i]+", ");
}
```
<h3>Another fix</h3>
Skip over the first iteration of the for-loop and continue starting at the next iteration of the for-loop.

```java
for(int i=0; i<nums.length; i++){
    //do something
    if(i==5){
        i++;
    }
    System.out.println(nums[i]+", ");
}
```
<h2>Skip over an element in an array</h2>
Suppose you wanted to skip over the sixth element in an array.

Why will this code sometimes error out?

```java
for(int i=0; i<nums.length; i++){
    //do something
    if(i==5){
        i++;
    }
    System.out.println(nums[i]+", ");
}
```
If the array is less than six elements the code will work fine. If the array is more than six elements long, the code will work fine. If the array is exactly six elements long, then the <code>i++</code> will skip over the sixth element and move to the index number of the 7th element. However, when it tries to print out the value of the 7th element, it will throw an error because there is no 7th element.

<h3>A fix: Change the order and adjust</h3>

```java
for(int i=0; i<nums.length; i++){
    //do something
    System.out.println(nums[i]+", ");
    if(i==4){
        i++;
    }
}
```
Skip over the fifth element (index 4) at the very end. Then have the for-loop take responsibility for skipping over the 6th element (index 5). Doing it in this order will trigger the for-loop to stop if going to the seventh element (index 6) causes the for-loop to surpass the length of the array.


<h3>Another fix: Use continue instead</h3>

```java
for(int i=0; i<nums.length; i++){
    //do something
    if(i==5){
        continue;
    }
    System.out.println(nums[i]+", ");
}
``` 
This fix is more elegant and more readable in my opinion. However, in some situations the other fix may be easier.

<h2>Replace the first even number with a 0</h2>
What's the problem with the code below?

```java
for(int i=0; i<nums.length; i++){
    if(nums[i]%2==0){
        nums[i] = 0;
    }
}
```
The issue is that it replaces all even numbers with a 0 rather than just the first even number.
<h3>A Fix: Flip a boolean</h3>
In general, flipping a boolean can make your code more readable. You can also employ this strategy to do more tricky things. 

```java
boolean hasFirstEvenHappened = false;
for(int i=0; i<nums.length; i++){
    if(!hasFirstEvenHappened && nums[i]%2==0){
        nums[i]=0;
        hasFirstEvenHappened = true;
    }
}
```
If you have a more complex situation than this, you could have multiple boolean variables that you are flipping back and forth in different situations.





