# Architecture Decision Record (ADR) - 001: Containerization Strategy

**Date:** 2025-04-29

**Status:** Approved

## 1. Context

The "report" Spring Boot application needs to be containerized for deployment. This decision record outlines the chosen strategy for building the Docker image using the Spring Boot Maven plugin.

## 2. Decision

We will leverage the `spring-boot-maven-plugin`'s `build-image` goal to create a Docker image directly from the Maven build process. We will further configure the plugin to utilize a specific buildpack (`bellsoft/buildpacks.builder:musl`) and enforce the use of Java 21 within the container.



## 3. Rationale

Several options were considered for containerizing the Spring Boot application:

* **Manual Dockerfile creation:** This involves writing a `Dockerfile`.
* **Jib Maven plugin:** Jib is a Google-developed Maven plugin that builds optimized Docker and OCI images.
* **`Docker compose`.**

We opted for the `spring-boot-maven-plugin` for the following reasons:

* **It is a quick POC type project therefor we decided to go with it.**
* **Simplicity and Integration** .
* **Buildpack Abstraction:** It utilizes Cloud Native Buildpacks.
* **Customization:** As seen in the provided `pom.xml`, the plugin allows for customization of the builder image and environment variables, such as specifying the Java version.
* **Specific Java Version Control:** The `<env><BP_JVM_VERSION>21</BP_JVM_VERSION></env>` configuration ensures that the container image is built and runs with Java 21, regardless of the build environment's Java version.
* **Lightweight Image:** The choice of `bellsoft/buildpacks.builder:musl` aims for a smaller and more efficient container image based on Alpaquita Linux, which is compatible with Alpine Linux.

## 4. Implications

* **Build Process:** The Docker image creation will be part of the standard Maven build process when using the `spring-boot:build-image` goal.
* **Docker Image:** The resulting Docker image will be based on the chosen buildpack (`bellsoft/buildpacks.builder:musl`) and will include the necessary runtime environment for the Spring Boot application, configured to use Java 21.
* **Deployment:** The generated Docker image can then be pushed to a container registry (like AWS ECR) and used for deployment in container orchestration platforms (like AWS ECS or Kubernetes).
* **Dependencies:** The project will have a dependency on the `spring-boot-maven-plugin`.
* **Maintenance:** Updates to the buildpack or the Spring Boot Maven plugin version might require adjustments to the `pom.xml`.

## 5. Alternatives Considered (and Rejected)

* **Manual Dockerfile:** Rejected due to increased complexity and maintenance.


## 6. Future Considerations

* Exploring different buildpacks if the current one doesn't meet performance or size requirements.
* Investigating image layering strategies for further optimization.
* Potentially evaluating Jib in the future if more fine-grained control over image creation becomes necessary.

## 7. Approval

Approved by: [Asraful]

Date: 2025-04-29


# Architecture Decision Record (ADR) - 002: Deployment to AWS  ECR, ECS (Fargate), and ALB

**Date:** 2025-04-30

**Status:** Approved

## 1. Context

The "report" API, now containerized (as per ADR-001), needs a deployment strategy on AWS. 

## 2. Decision

We will initially deploy the "report" application to AWS using the following components, with manual creation of the infrastructure:

* **Amazon Elastic Container Registry (ECR)**
* **Amazon Elastic Container Service (ECS) with Fargate:** We will use ECS as the container orchestration service, leveraging the Fargate launch type (to be configured manually within an ECS cluster created manually).
* **Application Load Balancer (ALB):** An ALB will be used to handle incoming HTTP/HTTPS traffic, distribute it across the ECS tasks, and provide basic load balancing and health checks (to be provisioned and configured manually).

**Future Consideration:** Full Infrastructure as Code (IaC) using Terraform will be implemented in a subsequent phase.
    -- API Gateway 
    -- VPC 

## 3. Rationale

The following factors influenced this initial simplified decision:

* **Faster Initial Setup** 
* **Learning Curve** 
* **Iterative Approach** 

* **However, we acknowledge the limitations of manual infrastructure management and recognize the benefits of IaC for long-term maintainability, repeatability, and scalability.**
  * **Therefore full IaC with Terraform is planned for the future.**

The choice of ECR, ECS (Fargate), and ALB remains the same as in the previous ADR due to their scalability, reliability, reduced operational overhead (especially with Fargate), security, and integration with each other.

Alternatives considered (and still rejected for the same reasons as in ADR-002):

* **EC2-based ECS:** Higher operational overhead.
* **Elastic Beanstalk:** Less control and potentially higher long-term costs.
* **Kubernetes (EKS):** Increased complexity for the current needs.

## 4. Implications (Initial Manual Setup)

* **Manual Infrastructure Creation** 
  * The team will be responsible for manually creating the ECR repository, ECS cluster, ECS service, task definition, and ALB through the AWS Management Console.
* **Networking**
  * Default VPC
  * On demand security groups 
  * Mapping TCP 888
  * Mapping HTTP 80
* **Monitoring and Logging
  * Cloud watch log groups 


## 5. Future Considerations (Full IaC with Terraform)

* **Terraform Implementation:** In a subsequent phase, we will define the entire infrastructure (ECR, ECS cluster and service, task definition, ALB, networking, etc.) using Terraform.
* **Automation:** This will enable fully automated provisioning and management of the AWS infrastructure.
* **API Gateway**
* **Custom VPC**

## 6. Approval

Approved by: [Asraful]

Date: 2025-04-30

