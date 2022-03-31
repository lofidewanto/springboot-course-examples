## Build image

mvnd spring-boot:build-image

https://docs.docker.com/registry/deploying

docker tag docker.io/library/spring-cloud-k8s:1.0.0-SNAPSHOT localhost:5000/spring-cloud-k8s:1.0.0-SNAPSHOT
docker push localhost:5000/spring-cloud-k8s:1.0.0-SNAPSHOT

kubectl apply -f deployment.yaml
kubectl get deployments
kubectl get pods

kubectl apply -f service.yaml

kubectl get service

kubectl get nodes -o wide

## App in K8s

http://192.168.65.4:8080/