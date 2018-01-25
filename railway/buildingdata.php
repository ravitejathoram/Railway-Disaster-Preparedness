 <?php
//error_reporting(1);
require "init.php" ;
$olat=$_POST["lat"];
$olon=$_POST["lon"];
//$cat=$_POST["cat"];
//$olat="18.151102";
//$olon="83.375673";

$sql_query="select * ,(3956 * 2 * ASIN(SQRT( POWER(SIN(( $olat - LATITUDE) *  pi()/180 / 2), 2) +COS( $olat * pi()/180) * COS(LATITUDE * pi()/180) * POWER(SIN(( $olon - LONGITUDE) * pi()/180 / 2), 2) ))) as distance  
from data having distance <= 2  ";

$result=mysqli_query($con,$sql_query);

if(mysqli_num_rows($result)>0)
{
  while($row=mysqli_fetch_assoc($result)  ) {
  $nam=$row["NAME"];
  $lat=$row["LATITUDE"];
  $lon=$row["LONGITUDE"];
  $addr=$row["ADDRESS"];
  $phn=$row["PHONE"];
  $cat=$row["CATEGORY"];
  echo $nam."!".$lat."!".$lon."!".$addr."!".$phn."!".$cat."@";

}
}

else
{
  echo "No Places Found";
}


 ?>
