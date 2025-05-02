# Manual Deployment to AWS ECS
This guide outlines the steps to manually deploy a Dockerized application to AWS Elastic Container Service (ECS), assuming you have already created your Elastic Container Registry (ECR) repository.

## Future Improvement : This should be automated through CI/CD

## Prerequisites

* **AWS CLI configured:** You need the AWS Command Line Interface installed and configured with your AWS credentials.
* **Docker installed:** Ensure Docker is installed on your local machine.
* **ECR Repository created:** You should have an existing ECR repository in your AWS account where you will push your Docker image.

## Step 1: Build Your Docker Image

Build your Docker image:

    mvn spring-boot:build-image -Dmodule.image.name=<provide name>


## Step 2:  Authenticate Docker with AWS ECR
    
    aws ecr get-login-password --region <your_aws_region> | docker login --username AWS --password-stdin <your_aws_account_id>.dkr.ecr.<your_aws_region>.amazonaws.com

    Example : aws ecr get-login-password --region eu-north-1 | docker login --username AWS --password-stdin 818346694630.dkr.ecr.eu-north-1.amazonaws.com


## Step 3: Tag Your Docker Image for ECR
    
    docker tag <your_app_name>:<tag> <your_aws_account_id>.dkr.ecr.<your_aws_region>[.amazonaws.com/](https://.amazonaws.com/)<your_repo_name>:<tag>
    
    Example : docker tag report:0.0.1-SNAPSHOT 818346694630.dkr.ecr.eu-north-1.amazonaws.com/report:0.0.1-SNAPSHOT

## Step 4: Push image to ECR
 
    docker push <your_aws_account_id>.dkr.ecr.<your_aws_region>[.amazonaws.com/](https://.amazonaws.com/)<your_repo_name>:<tag>
 
    Example : docker push  818346694630.dkr.ecr.eu-north-1.amazonaws.com/asraful-dev


## ECR Reference : 


![Screenshot 2025-05-03 at 2 20 30](https://github.com/user-attachments/assets/604f5cb5-5a61-4a79-981f-ca9e18c50be2)




![Screenshot 2025-05-03 at 2 23 48](https://github.com/user-attachments/assets/7f5d18a1-3c06-468a-a844-af238bde057f)


## Deployed Service :


![Screenshot 2025-05-03 at 2 27 29](https://github.com/user-attachments/assets/3eb7a706-cd89-4f89-b2ab-403d14462ff4)

