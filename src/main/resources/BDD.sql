-- Généré le :  Dim 10 Décembre 2017 à 18:16


SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `test`
--

-- --------------------------------------------------------
CREATE DATABASE IF NOT EXISTS 'Site';
--
-- Structure de la table `personnage`
--

CREATE TABLE IF NOT EXISTS `personnage` (
  `personnage_id`   INT(50)     NOT NULL,
  `personnage_name` VARCHAR(30) NOT NULL,
  PRIMARY KEY ('personnage_id')
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

--
-- Structure de la table `episode`
--

CREATE TABLE IF NOT EXISTS `episode` (
  `episode_id` int(50) NOT NULL,
  `titre` varchar(500) NOT NULL,
  `parution` int(5) NOT NULL,
  `avis` int(10) NOT NULL,
  `resume` varchar(500) NOT NULL,
  `personnage_id` int(50) NOT NULL,
  `image_url` varchar(500) NOT NULL,
  PRIMARY KEY ('episode_id')
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;


--
-- Structure de la table `messages`
--

CREATE TABLE IF NOT EXISTS `commentaire` (
  `idcommentaire` int(50) NOT NULL,
  `user` varchar(500) NOT NULL,
  `user_email` varchar(500) NOT NULL,
  `user_commentaire` varchar(5000) NOT NULL,
  PRIMARY KEY ('idcommentaire')
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

--
-- Contenu de la table `personnage`
--

INSERT INTO `personnage` (`personnage_id`, `personnage_name`) VALUES
(1, 'Jon Snow'),
(2, 'Daenerys Targaryen'),
(3, 'Sansa Stark'),
(4, 'Arya Stark'),
(5, 'Cersei Lannister'),
(6, 'Tyrion Lannister'),
(7, 'Jaime Lannister'),
(8, 'Theon Greyjoy');


-- --------------------------------------------------------

--
-- Contenu de la table `episode`
--

INSERT INTO `episode` (`episode_id`, `titre`, `parution`, `avis`, `resume`, `personnage_id`) VALUES
(1, 'Dragonstone', 2017, 3, 'http://www.game-of-thrones.fr/vos-reactions-sur-lepisode-7x01-de-game-of-thrones-dragonstone/', 2),
(2, 'Stormborn', 2017, 4, 'http://www.game-of-thrones.fr/vos-reactions-sur-lepisode-7x02-de-game-of-thrones-stormborn/', 8),
(3, 'The Queens Justice', 2017, 4, 'http://www.game-of-thrones.fr/vos-reactions-sur-lepisode-7x03-de-game-of-thrones-the-queens-justice/', 6),
(4, 'The Spoils Of War', 2017, 4, 'http://www.game-of-thrones.fr/vos-reactions-sur-lepisode-7x04-de-game-of-thrones-the-spoils-of-war/', 1),
(5, 'Eastwatch', 2017, 5, 'http://www.game-of-thrones.fr/vos-reactions-sur-lepisode-7x05-de-game-of-thrones-eastwatch/', 3),
(6, 'Beyond The Wall', 2017, 3, 'http://www.game-of-thrones.fr/vos-reactions-sur-lepisode-7x06-de-game-of-thrones-beyond-the-wall/', 5),
(7, 'The Dragon And The Wolf', 2017, 3, 'http://www.game-of-thrones.fr/vos-reactions-sur-lepisode-7x07-de-game-of-thrones-the-dragon-and-the-wolf/', 4),
-- --------------------------------------------------------


--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `personnage`
--
ALTER TABLE `personnage`
  MODIFY `personnage_id` int(50) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT pour la table `episode`
--
ALTER TABLE `episode`
  MODIFY `episode_id` int(50) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT pour la table `messages`
--
ALTER TABLE `commentaire`
  MODIFY `idcommentaire` int(50) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=1;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;