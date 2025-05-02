# Tepsivo.PV.AWS - API Test Report

### Tool : POSTMAN 

## Endpoints

### 1. New Report
- **Endpoint**: `POST /reports`
- **Description**: Create a new drug-related report.
- **Authentication**: API Key
    - Key: `X-API-KEY`
    - Value: `PV001xtv`
  

- **Request URL**:
  ```http
  http://drug-reports-alb-390816149.eu-north-1.elb.amazonaws.com/reports/

- **Request Body**:
  ```json
    {
    "reporterName": "PV Tester asc",
    "productName": "Panadol-500",
    "description": "Vomiting",
    "timestamp": "2025-05-02T14:30:00Z"
    }

- **Response Body**:
  ```json
    {
    "id": "00ff6789-7b64-495a-a3cd-edc5b1580428",
    "message": "Report created successfully"
    }


### 2. Reports By ID
- **Endpoint**: `GET /reports/{reportId}`
- **Description**: Fetch a report by its unique report ID.
- **Authentication**: API Key
    - Key: `X-API-KEY`
    - Value: `PV001xtv`


- **Request URL**:
  ```http
  http://drug-reports-alb-390816149.eu-north-1.elb.amazonaws.com/reports/{reportId}

- **Query Parameters**::
    ```
    reportId: The unique ID of the report you wish to retrieve.
   
- **Response Body**:
  ```json

    {
    "id": "00ff6789-7b64-495a-a3cd-edc5b1580428",
    "reporterName": "PV Tester asc",
    "productName": "Panadol-500",
    "description": "Vomiting",
    "timestamp": "2025-05-02T14:30:00Z",
    "status": "NEW"
    }



### 3. Reports By Status
- **Endpoint**: `GET /reports?status={status}`
- **Description**: Fetch all reports filtered by status.
- **Authentication**: API Key
    - Key: `X-API-KEY`
    - Value: `PV001xtv`

- **Request URL**:
  ```http
  http://drug-reports-alb-390816149.eu-north-1.elb.amazonaws.com/reports?status=NEW


- **Query Parameters**:
    - `status`: The status of the reports to filter by. Common values include:
        - `NEW`
        - `IN_PROGRESS`
        - `RESOLVED`


- **Response Body**:
  ```json
    [
    {
    "id": "b7935a9a-7319-450e-8416-b0453906f015",
    "reporterName": "PV Tester",
    "productName": "Panadol",
    "description": "Vomiting",
    "timestamp": "2025-05-01T14:30:00Z",
    "status": "NEW"
    },
    {
    "id": "eec88e2d-e4b2-4836-b784-a0c72107fdec",
    "reporterName": "PV Tester",
    "productName": "Panadol",
    "description": "Vomiting",
    "timestamp": "2025-05-01T14:30:00Z",
    "status": "NEW"
    },
    {
    "id": "00ff6789-7b64-495a-a3cd-edc5b1580428",
    "reporterName": "PV Tester asc",
    "productName": "Panadol-500",
    "description": "Vomiting",
    "timestamp": "2025-05-02T14:30:00Z",
    "status": "NEW"
    }
    ]