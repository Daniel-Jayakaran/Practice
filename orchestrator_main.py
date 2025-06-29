from core.orchestrator import Orchestrator
from agents.fun_chat_agent import FunChatAgent
from agents.code_gen_agent import CodeGenAgent
from agents.idea_agent import IdeaAgent
from llm.llama_interface import classify_and_extract

# Initialize orchestrator
orchestrator = Orchestrator()

# Register agents
orchestrator.register_agent("fun", FunChatAgent)
orchestrator.register_agent("code", CodeGenAgent)
orchestrator.register_agent("idea", IdeaAgent)

def run():
    print(" Welcome to AI Agent Orchestrator by Daniel Jayakaran")
    while True:
        user_input = input("\nYou: ")
        if user_input.lower() == "exit":
            break

        classification = classify_and_extract(user_input)
        task_type = classification['task_type']
        tasks = classification['tasks']

        print(f"\n Task Type: {task_type}")

        output = orchestrator.run(task_type, user_input)
        print(f"\n Response:\n{output}")

if __name__ == "__main__":
    run()
