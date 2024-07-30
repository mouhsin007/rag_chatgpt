import { EndpointRequestInit as EndpointRequestInit_1 } from "@vaadin/hilla-frontend";
import client_1 from "./connect-client.default.js";
async function ask_1(question: string, init?: EndpointRequestInit_1): Promise<string> { return client_1.call("ChatAiService", "ask", { question }, init); }
export { ask_1 as ask };
