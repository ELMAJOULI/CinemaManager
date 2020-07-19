
const ul = document.querySelector('.page');
let startPage = 0;
let endPage = 2;

console.log(parseInt(getURLParameter('page')));




if (!isNaN(parseInt(getURLParameter('page')))) {
    startPage = parseInt(getURLParameter('page'));
    endPage = startPage + 2;
}





function getURLParameter(name) {
    return decodeURIComponent((new RegExp('[?|&]' + name + '=' + '([^&;]+?)(&|#|;|$)').exec(location.search) || [null, ''])[1].replace(/\+/g, '%20')) || null;
}

function nextHandler() {
    startPage += 3;
    endPage += 3;
    if (endPage >= pages.length ){
        endPage = pages.length -1;
        startPage = endPage - 2;
    }
    navPage(startPage, endPage);
    console.log(document.URL);
    window.location = url + startPage;

}

function previousHandler() {


    startPage -= 2;
    endPage -= 2;
    if (startPage < 0){
        startPage = 0;
        endPage = 2;
    }
    navPage(startPage, endPage);
    window.location = url + startPage;

}

console.log(startPage);
console.log(endPage);


function navPage(s = 0, e = 3) {

    ul.innerHTML = "";
    if (e >= pages.length) {

        const previous = document.createElement('li');
        const ap = document.createElement('a');
        ap.innerHTML = 'Previous';
        previous.appendChild(ap);
        previous.addEventListener('click', previousHandler);
        ul.appendChild(previous);
        for (let i = s; i < pages.length; i++) {
            const href = pages[i];
            const li = document.createElement('li');
            const a = document.createElement('a');
            a.href = href + i;
            a.innerHTML = 1 + i;
            li.appendChild(a);
            ul.appendChild(li);
        }
    } else if (s <= 0) {
        const next = document.createElement('li');
        const an = document.createElement('a');
        an.innerHTML = 'Next';
        next.appendChild(an);
        next.addEventListener('click', nextHandler);

        for (let i = 0; i <= e; i++) {
            const href = pages[i];
            const li = document.createElement('li');
            const a = document.createElement('a');
            a.href = href + i;
            a.innerHTML = 1 + i;
            li.appendChild(a);
            ul.appendChild(li);
        }
        ul.appendChild(next);

    } else {

        const previous = document.createElement('li');
        const ap = document.createElement('a');
        ap.innerHTML = 'Previous';

        previous.appendChild(ap);
        previous.addEventListener('click', previousHandler);

        ul.appendChild(previous);

        const next = document.createElement('li');
        const an = document.createElement('a');
        an.innerHTML = 'Next';
        next.appendChild(an);
        next.addEventListener('click', nextHandler);
        for (let i = s; i <= e; i++) {
            const href = pages[i];
            const li = document.createElement('li');
            const a = document.createElement('a');
            a.href = href + i;
            a.innerHTML = 1 + i;
            li.appendChild(a);
            ul.appendChild(li);
        }
        ul.appendChild(next);
    }
    ul.querySelectorAll('li').forEach(liNode => {

        let a = liNode.querySelector('a');
        if (parseInt(a.innerHTML) === startPage + 1) {
            a.classList.add('selected');
        }
    });

}
navPage(startPage, endPage);