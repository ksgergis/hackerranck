#https://www.hackerrank.com/challenges/nested-list

#This question solved part of learning Python series
#Goal to learn creation of list of lists
#get the second smallest grade, if multiple student have second smallest grade, print their names order Alphabetically
#I used heap of tuples instead, helped me to solve the Alphabetically order out of the box
#having fun with python
#python3


import heapq
if __name__ == '__main__':
	#loading the data from stdin
    gradeList = []
    for _ in range(int(input())):
        name = input()
        score = float(input())
        heapq.heappush(gradeList,(score,name))
    
    #get the smallest grade, skip all the students who got same grade
    smallest = heapq.heappop(gradeList)[0]
    while(heapq.nsmallest(1,gradeList)[0][0] == smallest ):
        heapq.heappop(gradeList)
    
    #get the second smallest grade, print the name of all students who got this grade ordered Alphabetically
    secondSmallest = heapq.heappop(gradeList)
    print(secondSmallest[1])
    while(heapq.nsmallest(1,gradeList)[0][0] == secondSmallest[0]):
        print(heapq.heappop(gradeList)[1])
 