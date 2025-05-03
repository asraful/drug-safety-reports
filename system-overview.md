
# 🧾 System Overview – Drug Safety Reporting API

## 📦 Directory Structure


![Screenshot 2025-05-03 at 15 26 45](https://github.com/user-attachments/assets/deea27e0-74f3-45cd-bcc8-fb33a175fec3)



---

## 🧩 Key Components

  - REST endpoints
  - Web security configuration
  - Basic service and data access layer

---


## 🧩 AWS architecture


![AWS diagram](https://github.com/user-attachments/assets/c732e751-367a-47f5-9261-fca0fba3ac64)


## Hoever this could be improved by getting inspired by :

  [Detail Example](https://docs.aws.amazon.com/prescriptive-guidance/latest/patterns/deploy-an-amazon-api-gateway-api-on-an-internal-website-using-private-endpoints-and-an-application-load-balancer.html])
---


## 🛡️ Security

- Uses **basic authentication** or a static **API key (`X-API-KEY: PV001xtv`)** for secured endpoints.
- All endpoints are protected; unauthorized requests return `401 Unauthorized`.

---

## 🧪 Testing

- A set of unit tests verify core service logic.
- Postman collection provided under `/api/postman-collection`.

---

## 🚀 Deployment Notes

- [📋 Deploy to AWS](deploy-to-aws.md)

---

## 🔧 Future Improvements

- Use a persistent data store (PostgreSQL)
- Add pagination and advanced search to `/reports`
- Improve authentication with external authentication provider
- Set up CI/CD pipeline
- Implement audit logging and error monitoring
- IoC code using terraform and integrated with CI/CD
- Improved exception handling
- Expose API with API gateway 
