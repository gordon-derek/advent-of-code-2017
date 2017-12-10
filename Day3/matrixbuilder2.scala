import scala.io.Source
import scala.util.control.Breaks._


var TARG = 361527
val arrsz = 604
val matrix = Array.ofDim[Int](arrsz,arrsz)
BuildMatrix()
//exit point always arrsz/2
var exit = arrsz/2
var targRow = 0
var targCol = 0
var target = 361527
FindIndex()

//count number of moves
var count = 0

//travel north/south first
if(targRow > exit){
	while(targRow != exit){
		targRow -= 1
		count += 1
	}
}
else if(targRow < exit){
	while(targRow != exit){
		targRow += 1
		count += 1
	}
}
//travel east/west
if(targCol > exit){
	while(targCol != exit){
		targCol -= 1
		count += 1
	}
}
else if(targCol < exit){
	while(targCol != exit){
		targCol += 1
		count += 1
	}
}

println(count)

def FindIndex(){
	breakable{
		for(i <- 0 to arrsz-1){
			for(j <- 0 to arrsz-1){
				if(matrix(i)(j) == target){
					targRow = i
					targCol = j
					break
				}
			}
		}
		targCol = -1
	}
}

def BuildMatrix(){
	ArrInit()
	//traverse initialize to 2
	var traverse = 2

	var row = arrsz/2
	var col = arrsz/2
	var curNum = 1
	matrix(row)(col) = curNum
	curNum += 1

	while(row < arrsz && col < arrsz){
		//start right 1
		col += 1
		//go up traverse-1
		for(i <- 0 to traverse-1){
			matrix(row-i)(col) = curNum
			curNum += 1
		}
		row = row - traverse + 1
		//go left traverse
		for(i <- 1 to traverse){
			matrix(row)(col-i) = curNum
			curNum += 1
		}
		col = col - traverse
		//traverse down
		for(i <- 1 to traverse){
			matrix(row+i)(col) = curNum
			curNum += 1
		}
		row = row + traverse
		//traverse right
		for(i <- 1 to traverse){
			matrix(row)(col+i) = curNum
			curNum += 1
		}
		col = col + traverse
		if(curNum > TARG)
			row = arrsz
		traverse += 2
	}
}
def ArrInit(){
	for(i <- 0 to arrsz-1)
		for(j <- 0 to arrsz-1)
			matrix(i)(j) = 0
}

def PrintMat(){
	for(i <- 0 to arrsz-1){
		for(j <- 0 to arrsz-1){
			var space = ""
			if (matrix(i)(j) < 10)
				space = "    "
			else if(matrix(i)(j) < 100)
				space = "   "
			else if(matrix(i)(j) < 1000)
				space = "  "
			else
				space = " "
			print(space + matrix(i)(j))
		}
		print('\n')
	}
}

