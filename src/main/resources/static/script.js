function init() {
    let button = document.getElementById("btn");
    button.onclick = function () {
        let start = new Date(document.getElementById("startDate").value).getTime();
        let end = new Date(document.getElementById("endDate").value).getTime();
        let path = "/dataPack/get?from=" + start + "&to=" + end;
        downloadFile(path);
    }
}

function downloadFile(urlToSend) {
    let req = new XMLHttpRequest();
    req.open("GET", urlToSend, true);
    req.responseType = "blob";
    req.onload = function (event) {
        let blob = req.response;
        let link = document.createElement('a');
        link.href = window.URL.createObjectURL(blob);
        link.download = "data.zip";
        link.click();
        document.body.removeChild(link);
    };

    req.send();
}

init();