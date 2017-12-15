/*fixe le header après le scroll */

var header = document.querySelector("header");

function scrolled() {
    var windowHeight = document.body.clientHeight, currentScroll = document.body.scrollTop
        || document.documentElement.scrollTop;

    header.className = (currentScroll >= windowHeight - header.offsetHeight) ? "fixed"
        : "";
}

function addCommentaire() {
    var requeteAddCommentaire = new XMLHttpRequest();
    requeteAddCommentaire.open("POST", "ws/commentaire/add", true);
    requeteAddCommentaire.responseType = "json";

    var user = document.getElementById("addUser").value;
    var user_email = document.getElementById("addEmail").value;
    var message = document.getElementById("addMessage").value;

    requeteAddCommentaire.setRequestHeader("Content-type",
        "application/x-www-form-urlencoded");
    requeteAddCommentaire.send("user=" + user + "&email=" + user_email
        + "&message=" + message);

    requeteAddCommentaire.onload=function(){
        window.alert("Message envoyé !");
        document.getElementById("addUser").value="";
        document.getElementById("addEmail").value="";
        document.getElementById("addMessage").value="";
    };

};

//Fonction pour ajouter un épisode
function addEpisode() {
    var requeteAddLivre = new XMLHttpRequest();
    requeteAddEpisode.open("POST", "ws/livre/add", true);
    requeteAddEpisode.responseType = "json";

    var titre = document.getElementById("addTitre").value;
    var parution = document.getElementById("addParution").value;
    var personnage = document.getElementById("addPersonnage").value;
    var avis = checkRating();

    requeteAddEpisode.setRequestHeader("Content-type",
        "application/x-www-form-urlencoded");
    requeteAddEpisode.send("titre=" + titre + "&parution="
        + parution + "&personnage=" + personnage + "&avis=" + avis );

    requeteAddEpisode.onload = function() {
        /*window.alert("Episode ajouté");*/
        titre = document.getElementById("addTitre").value = "";
        parution = document.getElementById("addParution").value = "";
        personnage = document.getElementById("addPersonnage").value = "";
    };
};

//Fonction pour modifier un épisode
function modifierEpisode(episode_id){
    var requeteModifierEpisode = new XMLHttpRequest();
    requeteModifierEpisode.open("POST", "ws/livre/modif", true);
    requeteModifierEpisode.responseType = "json";

    var EpisodeAModifier = episode_id;
    var titre=document.getElementById("modifTitre").value;
    var parution=document.getElementById("modifParution").value;
    var avis=document.getElementById("modifAvis").value;

    requeteModifierEpisode.setRequestHeader("Content-type",
        "application/x-www-form-urlencoded");
    requeteModifierEpisode.send("episode_id=" + EpisodeAModifier+ "titre=" + titre + "&parution="
        + parution + "&avis=" + avis );
};

//Fonction pour supprimer l'épisode
function openDialogConfirm(episode_id) {
    var requeteDeleteEpisode = new XMLHttpRequest();
    requeteDeleteEpisode.open("POST", "ws/livre", true);
    requeteDeleteEpisode.responseType = "json";

    var episodeADelete = episode_id;

    var r = confirm("Etes-vous sur de vouloir supprimer l'épisode " + episode_id
        + " ? Cette action est irréversible.");
    if (r == true) {
        requeteDeleteEpisode.setRequestHeader("Content-type",
            "application/x-www-form-urlencoded");
        requeteDeleteEpisode.send("id=" + episodeADelete);
        var boutonSuppr = document.getElementById(episode_id);
        var tr = boutonSuppr.parentElement;
        var table = tr.parentElement;
        table.removeChild(tr);
    };
};

window.onload = function() {

};