
# 🧾 System Overview – Drug Safety Reporting API

## 📦 Project Structure




---

## 🧩 Key Components



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



---

## 🔧 Future Improvements

- Use a persistent data store (PostgreSQL)
- Add pagination and advanced search to `/reports`
- Improve authentication with external authentication provider
- Set up CI/CD pipeline
- Implement audit logging and error monitoring
- IoC code using terraform and integrated with CI/CD
- Improved exception handling
