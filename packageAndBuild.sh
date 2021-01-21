echo "===================="
echo "===================="
echo "BUILDING A WAR"
echo "===================="
echo "===================="
mvn package

echo "...................."
sleep 3

echo "===================="
echo "===================="
echo "BUILDING A CONTAINER TOMCAT+WAR"
echo "===================="
echo "===================="
docker build . -t product-retrieval-tomcat

echo "...................."
sleep 3

echo "===================="
echo "===================="
echo "Run the following command after closing the 8081 port on your localhost"
echo "otherwise it will fail to start the server"
echo ""
echo "docker run -p 8081:8080 -t product-retrieval-tomcat"
echo ""
echo "===================="
echo "===================="