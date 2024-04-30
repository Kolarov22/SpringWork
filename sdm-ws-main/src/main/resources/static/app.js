let username = null;
let socket = null;
let stompClient = null;

function login() {
    const usernameInput = document.getElementById('usernameInput');
    username = usernameInput.value.trim();
    if (username == "admin") {
        document.getElementById('loginForm').style.display = 'none';
        document.getElementById('admin-console').style.display = 'block';
        console.log("Calling connectAdmin");
        connectAdmin();
    }

    else{
        document.getElementById('loginForm').style.display = 'none';
        document.getElementById('auctions').style.display = 'block';
        console.log("Calling connectUser");
        connectUser();
    }
}

function connectAdmin() {
    socket = new SockJS('/chat');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log('Connected: ' + frame);

    },
        function (error) {
            console.log('Connection error: ' + error);
            setTimeout(connect, 5000);
        });
}

function connectUser(){
    socket = new SockJS('/chat');
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
            console.log('Connected: ' + frame);
            stompClient.subscribe('/topic/auctions', function (auction) {
                showAuctions(JSON.parse(auction.body));
            });
        },
        function (error) {
            console.log('Connection error: ' + error);
            setTimeout(connectUser, 5000);
        });
}

function sendAuction() {
    const auctionName = document.getElementById("auctionName");
    const bidderName = document.getElementById("bidderName");
    const auctionPrice = document.getElementById("auctionPrice");
    const expirationTime = document.getElementById("expirationTime");
    const name = auctionName.value.trim();
    const bidder = bidderName.value.trim();
    const price = auctionPrice.value.trim();
    const expTime = expirationTime.value.trim();

    if (name && bidder && price && expTime) {
        const auction = {
            name: name,
            bidder: bidder,
            minPrice: price,
            expirationTime: expTime
        }
        stompClient.send("/app/chat.sendAuction", {}, JSON.stringify(auction));
        auctionName.value='';
        bidderName.value='';
        auctionPrice.value='';
        expirationTime.value='';

    }
}

function showAuctions(message) {
    console.log('Received: ' + message);
    const auctionsList = document.getElementById('auctionList');
    const entry = document.createElement('li');
    const update = document.createElement('button')
    const newPrice = document.createElement("input")
    update.textContent="Bid"
    update.id = "updateButton"
    newPrice.id = "updatedPrice"
    entry.textContent = message.name + " " + message.bidder + " " + message.minPrice + " "+ message.expirationTime;
    entry.appendChild(update);
    entry.appendChild(newPrice);
    auctionsList.appendChild(entry);
    auctionsList.scrollTop = auctionsList.scrollHeight;
}

function sendBid(){
    const newPrice = document.getElementById("updatedPrice");

}

document.getElementById('loginButton').addEventListener('click', function (e) {
    e.preventDefault();
    login();
});

document.getElementById('auctionForm').addEventListener('submit', function (e) {
    e.preventDefault();
    sendAuction();
});

document.getElementById('updateButton').addEventListener('click', function(e){
    e.preventDefault();
    sendBid();
})
