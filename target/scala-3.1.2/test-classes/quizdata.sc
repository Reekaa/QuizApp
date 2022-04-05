import scala.collection.mutable.Map

var mapBuffer: Map[String, List[(String, Int)]] = Map()

var key ="US States 5 letters or less (Geography)"
var newList = List(("Iowa",0),("Maine",72),("Ohio",108),("Texas",144),("Utah",0),("Idaho",36))
mapBuffer = mapBuffer ++ Map(key -> newList)

key ="European Football World Cup Winners (Sports)"
newList = List(("England",72),("France",48),("Italy",48),("Germany",48),("West Germany",0),("Spain",24))
mapBuffer = mapBuffer ++ Map(key -> newList)

key ="UK Top 10 Genesis Singles (Music)"
newList = List(("Follow You Follow Me",55),("Turn It On Again",77),("Abacab",0),("Paperlate",0),("Mama",11),("No Son Of Mine",11),("I Can't Dance",66),("Invisible Touch (Live)",0))
mapBuffer = mapBuffer ++ Map(key -> newList)

key ="Scottish Cities (Geography)"
newList = List(("Glasgow",75),("Edinburgh",75),("Aberdeen",45),("Dundee",45),("Perth",15),("Stirling",15),("Inverness",30))
mapBuffer = mapBuffer ++ Map(key -> newList)

key ="Wives of Henry VIII (History)"
newList = List(("Catherine Of Aragon",33),("Catherine Howard",32),("Catherine Parr",32),("Jane Seymour",32),("Anne Boleyn",40),("Anne Of Cleeves",31))
mapBuffer = mapBuffer ++ Map(key -> newList)

key ="Genesis Members (Music)"
newList = List(("Banks",30),("Rutherford",30),("Collins",45),("Hackett",15),("Gabriel",24),("Wilson",3),("Phillips",3),("Stewart",0),("Mayhew",0))
mapBuffer = mapBuffer ++ Map(key -> newList)

key ="Labour Prime Ministers (Politics)"
newList = List(("MacDonald",13),("Atlee",20),("Wilson",60),("Callaghan",7),("Blair",200),("Brown",100))
mapBuffer = mapBuffer ++ Map(key -> newList)

key ="Test Cricket Nations (Sports)"
newList = List(("Australia",30),("England",27),("South Africa",20),("West Indies",31),("New Zealand",20),("India",30),("Pakistan",29),("Sri Lanka",7),("Zimbabwe",0),("Bangladesh",0),("Ireland",6),("Afghanistan",0))
mapBuffer = mapBuffer ++ Map(key -> newList)

key ="Barcelona Goalscorers in Champions League Final (Sports)"
newList = List(("Koeman",10),("Eto'o",20),("Belletti",0),("Messi",100),("Pedro",0),("Villa",0),("Rakitic",0),("Suarez",30),("Neymar",40))
mapBuffer = mapBuffer ++ Map(key -> newList)