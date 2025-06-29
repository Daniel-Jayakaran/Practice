import requests
import json

OLLAMA_URL = "http://localhost:11434/api/generate" # ✅ match exactly with your LLM model Local Host Api URL
MODEL_NAME = "llama3.2"  # ✅ match exactly with your Ollama model name

def call_llama(prompt: str, max_tokens: int = 512) -> str:
    payload = {
        "model": MODEL_NAME,
        "prompt": prompt,
        "stream": False,
        "options": {
            "temperature": 0.7,
            "max_tokens": max_tokens
        }
    }

    response = requests.post(OLLAMA_URL, json=payload)
    response.raise_for_status()
    return response.json()["response"].strip()

def classify_and_extract(user_input: str):
    prompt = f"""
Classify the following user input into a task_type and extract relevant tasks.

Input: "{user_input}"

Respond ONLY in JSON:
{{
  "task_type": "fun" | "code" | "idea",
  "tasks": ["list", "of", "relevant", "task", "keywords"]
}}
"""
    try:
        output = call_llama(prompt, max_tokens=300)
        # Try to parse only the first JSON part
        json_part = output.split('\n')[0] if '\n' in output else output
        return json.loads(json_part)
    except Exception as e:
        print("[!] LLaMA classification error:", e)
        return {"task_type": "fun", "tasks": []}

def generate_response(task_type: str, tasks: list, user_input: str):
    task_str = ", ".join(tasks)
    prompt = f"""
You are an intelligent assistant.

Task Type: {task_type}
Tasks: {task_str}
User Input: "{user_input}"

Generate a long, smart, and helpful response.
"""
    return call_llama(prompt, max_tokens=600)
