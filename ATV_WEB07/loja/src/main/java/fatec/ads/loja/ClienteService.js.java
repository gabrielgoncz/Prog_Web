const API_URL = "http://localhost:8080/clientes";

export async function listarClientes() {
    try {
        const response = await fetch(API_URL);
        const data = await response.json();
        return data;
    } catch (error) {
        console.error("Erro ao buscar clientes:", error);
    }
}

export async function salvarCliente(cliente) {
    try {
        const response = await fetch(API_URL, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(cliente)
        });

        const data = await response.json();
        return data;
    } catch (error) {
        console.error("Erro ao salvar cliente:", error);
    }
}