# Analyzer Service - REST API Documentation

## Overview

This API provides a service to analyze images and generate pixel data in JSON format. It accepts the file path of an image, processes the image, and returns a confirmation response.

---

## Controller Details

**Controller Class:** `AnalyzerController`

**Base URL:** `/api/v1/analyzer-service`

---

## Endpoint Details

### 1. Generate JSON Image Pixel Data

- **URL example:** `http://localhost:8080/api/v1/analyzer-service/image/pixel/json`
- **Method:** `POST`
- **Description:** Processes an image from the provided file path and generates pixel data in JSON format.

#### Request

- **Body:** JSON object containing the file path of the image.
- **Content-Type:** `application/json`

**Request Body Example:**
```json
{
  "pathToFile": "/path/to/your/image.png"
}
