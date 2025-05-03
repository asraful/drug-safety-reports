# drug-safety-reports-api



# 📋 Project Requirements — Drug Safety Reporting API

This project is focused on building a minimal, clean, and deployable REST API for managing drug safety reports.

### Issue: [#1 Requirements](https://github.com/asraful/drug-safety-reports/issues/1)

---

## 📄 Documentation

- [📋 Test report showing API is running in AWS](free-form-report.md)
- [📋 Deploy to AWS](deploy-to-aws.md)
- [🧾 System Overview](system-overview.md)
- [🧾 Architecture Decision Record (ADR)](adr.md)

## 📄 API Spec and Postman Collection 

- [View the API Specification](open-api-spec/pv_safety_report.yml)
- [View POSTMAN Collection](postman-collection/postman-collection)


## 🚀 Clone, Build, and Run Locally

### ✅ Prerequisites

- Java 21 or higher
- Maven installed

### 🔧 Steps

1. **Clone the repository**

   ```bash
   git clone https://github.com/asraful/drug-safety-reports.git
   cd drug-safety-reports


2. **Build the project**

     ```bash
        mvn clean install

3. **Run the application**
      
    ```bash
      mvn spring-boot:run

4. **Access H2 Console**
    ```
    http://localhost:8888/h2-console/
    
    Forbidded by API key for now , if you need to access it , allow it in spring security filter
    
       | H2 Username | Password   |
       |-------------|------------|
       | `sa`        | `password` |
    
    You can change it in application.properties  

5. **Run the application**

    ```bash
      mvn spring-boot:run

## 📬 Import and Run Postman Collection

You can test the API endpoints easily using the provided Postman collection.

### 🗂️ Collection Location

The Postman collection file is available at:

    /api/postman-collection



### 🔧 Steps to Import and Run

1. **Open Postman**
2. Click on **"Import"** in the top-left corner
3. Select the collection file from `/api/postman-collection` in your project directory
4. Once imported, open any request in the collection

### 🔐 API Key Authentication

All requests require an API key in the headers:

| Header Key   | Value     |
|--------------|-----------|
| `X-API-KEY`  | `PV001xtv` |

You can set this at the **collection level** in Postman:

- Click on the collection name
- Go to the **"Authorization"** tab
- Set **Type** to `API Key`
- Key: `X-API-KEY`
- Value: `PV001xtv`
- Add to: `Header`

Now you’re ready to run requests and explore the API! ✅







    
