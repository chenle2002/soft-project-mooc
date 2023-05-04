sudo docker rm -f admin &> /dev/null
echo "start admin container..."
sudo docker run -d \
		-p 8081:8081\
                --name admin\
                service-admin  &> /dev/null

sudo docker rm -f course &> /dev/null
echo "start course container..."
sudo docker run -d \
		-p 8082:8082\
                --name course \
                service-course &> /dev/null
				
sudo docker rm -f member&> /dev/null
echo "start member container..."
sudo docker run -d \
		-p 8083:8083\
                --name member\
                service-member&> /dev/null

sudo docker rm -f oss&> /dev/null
echo "start oss container..."
sudo docker run -d \
		-p 8084:8084\
                --name oss\
                service-oss&> /dev/null

sudo docker rm -f sort&> /dev/null
echo "start sort container..."
sudo docker run -d \
		-p 8085:8085\
                --name sort\
                service-sort&> /dev/null


