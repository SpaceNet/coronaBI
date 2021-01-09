#!/bin/sh
SCRIPT_DIR=$(cd $(dirname $0); pwd)
echo $SCRIPT_DIR
. $SCRIPT_DIR/CONST.txt

gcloud config configurations activate corona-bi
gcloud container clusters get-credentials $CLUSTER_NAME

IMAGE_NAME=/corona-bi
PROJECT_REPOSITORY=gcr.io/$PROJECT_ID
IMAGE_FULL_NAME=gcr.io/$PROJECT_ID/corona-bi/extract-data

docker build -f src/main/docker/Dockerfile.jvm -t $IMAGE_FULL_NAME .

docker push $IMAGE_FULL_NAME