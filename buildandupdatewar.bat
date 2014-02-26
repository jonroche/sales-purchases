rem mvn clean install
rm "C:\Tools\STS 3.5M2\vfabric-tc-server-developer-2.9.4.RELEASE\base-instance\webapps\yourbusinesssolutions.war"
rmdir /S "C:\Tools\STS 3.5M2\vfabric-tc-server-developer-2.9.4.RELEASE\base-instance\webapps\yourbusinesssolutions"
cd target
cp yourbusinesssolutions.war "C:\Tools\STS 3.5M2\vfabric-tc-server-developer-2.9.4.RELEASE\base-instance\webapps\"
cd C:\SpringProject\Sales-Purchases