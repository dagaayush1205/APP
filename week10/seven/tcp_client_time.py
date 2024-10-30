import socket
import time

def tcp_client():
    # Define server address and port
    server_address = ('localhost', 65436)
    
    # Measure start time
    start_time = time.time()
    
    # Create a TCP socket
    with socket.socket(socket.AF_INET, socket.SOCK_STREAM) as client_socket:
        # Connect to the server
        client_socket.connect(server_address)
        print("Connected to server.")

        # Send a message to the server
        message = "Hello, Server!"
        client_socket.sendall(message.encode())
        print("Message sent to server.")

        # Receive response from the server
        response = client_socket.recv(1024).decode()
        print("Response from server:", response)

    # Measure end time and calculate elapsed time
    end_time = time.time()
    elapsed_time = end_time - start_time
    print("Time taken for connection and response:", elapsed_time, "seconds")

# Run the client
if __name__ == "__main__":
    tcp_client()

