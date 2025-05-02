output "ecr_repository_url" {
  description = "URL of the ECR repository"
  value       = aws_ecr_repository.drug_safety_repository.repository_url
}

output "repository_arn" {
  value       = aws_ecr_repository.drug_safety_repository.arn
  description = "The arn of the ECR repository"
}
