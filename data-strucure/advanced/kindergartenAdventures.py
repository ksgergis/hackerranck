# question link https://www.hackerrank.com/challenges/kindergarten-adventures

# reading the data
n = int(raw_input())
timeNeeded = map(int,raw_input().split())

#slow solution big O if n square
#getting list of list, where each list represents if the start student was the index of this list position
firstComb = [[1 if timeNeeded[(firstStudent+currentPosition)%n] -currentPosition <= 0 else 0 for currentPosition in range(n) ] for firstStudent in range(n)]

#combine them to one finel list, where each entry is the number of the stuedents finished it the index was starting student
finishedNum = [temp.count(1) for temp in firstComb ]
#get the max
print finishedNum.index(max(finishedNum)) + 1