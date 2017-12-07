import scala.io.Source

var sum = 0
for(line <- Source.fromFile("input.txt").getLines){
	var high = 0
	var low = 0
	var first = true
	var nums = line.split("\\s+")
	for (i <- 0 to nums.length-1){
		if (first == true){
			low = nums(i).toInt
			high = nums(i).toInt
			first = false
		}
		else{
			if(nums(i).toInt < low)
				low = nums(i).toInt
			if(nums(i).toInt > high)
				high = nums(i).toInt
		}
	}
	println(high + " " + low)
	sum = sum + high - low
}
println(sum)