from abc import ABC, abstractmethod
from llm.llama_interface import classify_and_extract

class BaseAgent(ABC):
    def __init__(self, user_input: str):
        self.user_input = user_input
        self.task_type = ""
        self.tasks = []

    def classify(self):
        result = classify_and_extract(self.user_input)
        self.task_type = result.get("task_type", "fun")
        self.tasks = result.get("tasks", [])

    @abstractmethod
    def handle(self):
        pass
