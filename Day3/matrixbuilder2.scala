import scala.io.Source
import scala.util.control.Breaks._


val TARG = 361527
var arrsz = 11
val matrix = Array.ofDim[Int](arrsz,arrsz)
ArrInit()
BuildMatrix()
//exit point always arrsz/2
var exit = arrsz/2
var targRow = 0
var targCol = 0
var target = 5       //361527
var curNum = 1

PrintMat()


def GetSum(centerRow: Int, centerCol: Int): Int ={
	var sum = 0
	if(centerRow >= 1){
		if(centerRow < arrsz-1){
			if(centerCol >= 1){
				if(centerCol < arrsz-1){
					sum += matrix(centerRow-1)(centerCol) +
					 matrix(centerRow-1)(centerCol-1) +
					 matrix(centerRow-1)(centerCol+1) +
					 matrix(centerRow)(centerCol-1) +
					 matrix(centerRow)(centerCol+1) +
					 matrix(centerRow+1)(centerCol-1) +
					 matrix(centerRow+1)(centerCol) +
					 matrix(centerRow+1)(centerCol+1)
				}else{
					sum += matrix(centerRow-1)(centerCol)
					sum += matrix(centerRow-1)(centerCol-1)
					sum += matrix(centerRow)(centerCol-1)
					sum += matrix(centerRow+1)(centerCol-1)
					sum += matrix(centerRow+1)(centerCol)
				}
			}else{
				sum += matrix(centerRow-1)(centerCol)
				sum += matrix(centerRow-1)(centerCol+1)
				sum += matrix(centerRow)(centerCol+1)
				sum += matrix(centerRow+1)(centerCol)
				sum += matrix(centerRow+1)(centerCol+1)
				sum += matrix(centerRow-1)(centerCol)
				sum += matrix(centerRow+1)(centerCol)
			}
		}else{
			if(centerCol >= 1){
				if(centerCol < arrsz-1){
					sum += matrix(centerRow-1)(centerCol)
					sum += matrix(centerRow-1)(centerCol-1)
					sum += matrix(centerRow-1)(centerCol+1)
					sum += matrix(centerRow)(centerCol-1)
					sum += matrix(centerRow)(centerCol+1)
				}else{
					sum += matrix(centerRow-1)(centerCol)
					sum += matrix(centerRow-1)(centerCol-1)
					sum += matrix(centerRow)(centerCol-1)
				}
			}else{
				sum += matrix(centerRow-1)(centerCol)
				sum += matrix(centerRow-1)(centerCol+1)
				sum += matrix(centerRow)(centerCol+1)
				sum += matrix(centerRow-1)(centerCol)	
			}
		}
	}else{
		if(centerRow < arrsz-1){
			println("here")
		}
	}

	return sum
}
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
	//traverse initialize to 2
	var traverse = 2

	var row = arrsz/2
	var col = arrsz/2
	matrix(row)(col) = 1
	PrintMat()
	curNum += 1
	breakable{
		while(row < arrsz && col < arrsz){
			//start right 1
			col += 1
			//go up traverse-1
			for(i <- 0 to traverse-1){
				curNum = GetSum(row-i,col)
				matrix(row-i)(col) = curNum
				if(curNum >= TARG)
					break
			}
			
			row = row - traverse + 1
			//go left traverse
			for(i <- 1 to traverse){
				curNum = GetSum(row,col-i)
				matrix(row)(col-i) = curNum
				if(curNum >= TARG)
					break		
			}
			
			col = col - traverse
			//traverse down
			for(i <- 1 to traverse){
				curNum = GetSum(row+i,col)
				matrix(row+i)(col) = curNum
				if(curNum >= TARG)
					break
			}
			
			row = row + traverse
			//traverse right
			for(i <- 1 to traverse){
				curNum = GetSum(row,col+i)
				matrix(row)(col+i) = curNum
				if(curNum >= TARG)
					break
			}
				
			col = col + traverse
				
			traverse += 2
		}
	}
	println("The first number is " + curNum)
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
				space = "      "
			else if(matrix(i)(j) < 100)
				space = "     "
			else if(matrix(i)(j) < 1000)
				space = "    "
			else if(matrix(i)(j) < 10000)
				space = "   "
			else if(matrix(i)(j) < 100000)
				space = "  "
			else
				space = " "
			print(space + matrix(i)(j))
		}
		print('\n')
	}
}

