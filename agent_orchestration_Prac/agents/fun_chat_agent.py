from core.base_agent import BaseAgent
from llm.llama_interface import generate_response

class FunChatAgent(BaseAgent):
    def handle(self):
        self.classify()
        return generate_response(self.task_type, self.tasks, self.user_input)
