This project shows how to use Spring Security in different ways — from basic filters to full OAuth2 login.
There are 3 branches, each one showing a different level of security setup.

⸻

🔹 Branch 1: main

👉 Full version — includes everything
	•	Spring Security FilterChain
	•	Google OAuth2 login
	•	HTML (Thymeleaf) login and home pages
	•	Complete flow from login → redirect → secure page

Use this branch if you want to see the full working project with all features together.

⸻

🔹 Branch 2: security-filterchain

👉 FilterChain-only version
	•	Basic Spring Security setup
	•	Uses in-memory users and roles
	•	No OAuth2 or HTML pages
	•	Best for learning how Spring filters and authorizes each request

Use this branch if you want to learn the basics of Spring Security step by step.

⸻

🔹 Branch 3: security-oauth2

👉 OAuth2-only version
	•	Only Google OAuth2 login (no HTML pages, no filter chain code)
	•	Clean and simple configuration
	•	Focuses only on the OAuth2 login and redirect flow

💡 Setup tip:
Go to src/main/resources/application.properties.example, copy it, and rename it to application.properties.
Then fill in your Google client ID and client secret before running.
