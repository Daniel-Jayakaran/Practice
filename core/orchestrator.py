# core/orchestrator.py

class Orchestrator:
    def __init__(self):
        self.agents = {}

    def register_agent(self, task_type: str, agent_class):
        self.agents[task_type] = agent_class

    def run(self, task_type: str, user_input: str):
        if task_type not in self.agents:
            raise ValueError(f"No agent registered for task_type: {task_type}")
        agent = self.agents[task_type](user_input)
        return agent.handle()
