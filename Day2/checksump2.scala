import scala.io.Source
import scala.util.control.Breaks._

var sum = 0
for(line <- Source.fromFile("input.txt").getLines){
	var splitnums = line.split("\\s+")
	var nums = splitnums map (_.toInt)
	breakable{
		for (i <- 0 to nums.length-1){
			for(j <- i+1 to nums.length-1){
	 			if(nums(i) >= nums(j) && nums(i) % nums(j) == 0){
	 				sum += nums(i)/nums(j)
	 				println(nums(i) + " i " + nums(j))
	 				break
	 			}
	 			else if(nums(j) >= nums(i) && nums(j) % nums(i) == 0){
	 				sum += nums(j)/nums(i)
	 				println(nums(j) + " j " + nums(i))
	 				break
	 			}
			}
		}
	}
}
println(sum)