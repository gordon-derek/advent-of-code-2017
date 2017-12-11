import scala.io.Source
import scala.util.control.Breaks._
import scala.collection.mutable.ListBuffer


var states = new ListBuffer[String]()
for(line <- Source.fromFile("input.txt").getLines){
	var cycles = 0
	var mem = line.split("\\s+")
	var blocks = mem map (_.toInt)
	var blockString = ""
	//convert block to String
	for(i <- 0 to blocks.size-1)
		blockString += blocks(i) + " "
	println(blockString)
	while(!states.contains(blockString)){
		states.append(blockString)
		//find highest bank
		cycles += 1
		var max = 0
		var blockVal = 0
		for(i <- 0 to blocks.size-1){
			if(blocks(i) > blockVal){
				max = i
				blockVal = blocks(i)
			}
		}
		blockVal = blocks(max)
		blocks(max) = 0
		//problem is here
		while(blockVal > 0){
			if(max == blocks.size-1){
				max = 0
				blocks(max) += 1
				blockVal -= 1
			}else{
				max += 1
				blocks(max) += 1
				blockVal -= 1
			}
		}
		blockString = ""
		for(i <- 0 to blocks.size-1)
			blockString += blocks(i) + " "

	}		
	println("First Reoccurance Took: " + cycles)	
	println("Repeated Block \n" + blockString)
	var target = blockString
	blockString = ""
	cycles = 0
	while(blockString != target){
		//find highest bank
		cycles += 1
		var max = 0
		var blockVal = 0
		for(i <- 0 to blocks.size-1){
			if(blocks(i) > blockVal){
				max = i
				blockVal = blocks(i)
			}
		}
		blockVal = blocks(max)
		blocks(max) = 0
		//problem is here
		while(blockVal > 0){
			if(max == blocks.size-1){
				max = 0
				blocks(max) += 1
				blockVal -= 1
			}else{
				max += 1
				blocks(max) += 1
				blockVal -= 1
			}
		}
		blockString = ""
		for(i <- 0 to blocks.size-1)
			blockString += blocks(i) + " "

	}	
	println(cycles)	

}