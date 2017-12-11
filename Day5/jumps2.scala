import scala.io.Source
import scala.collection.mutable.ListBuffer

var skip = 0
var count = 0
var position = 0
var commands = new ListBuffer[Int]()
BuildList()

//process list
while(position < commands.length){
	if(skip != 0){
		position += skip
		skip = 0
	}
	else{
		count += 1
		skip = commands(position)
		if(commands(position) >= 3)
			commands(position) -= 1
		else
			commands(position) += 1
	}
}

println(count)

//builf List
def BuildList(){
	for(line <- Source.fromFile("input.txt").getLines){
		commands.append(line.toInt)
	}
}
