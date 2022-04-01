## Build image

Info zu Docker Regustry:
https://docs.docker.com/registry/deploying

mvnd spring-boot:build-image

docker tag docker.io/library/spring-cloud-k8s:1.0.2-SNAPSHOT localhost:5000/spring-cloud-k8s:1.0.2-SNAPSHOT
docker push localhost:5000/spring-cloud-k8s:1.0.2-SNAPSHOT

kubectl apply -f deployment.yaml
kubectl get deployments
kubectl get pods

kubectl apply -f service.yaml

kubectl get service

kubectl get nodes -o wide

## App in K8s

Port forwarding to localhost

http://localhost:port/messages

Achtung: Portnummer muss noch gefunden werden!
