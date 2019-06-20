#!/bin/bash
function pidkill() {

str="program $name telah di matikan, $name"
echo $str

}

echo "program apa yang mau di matikan"
read name | pgrep name | kill name

val=$(pidkill)
echo  $val
