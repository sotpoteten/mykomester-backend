# backend

## Installasjon

```sh
mvn clean install
```

### Kjøring

```sh
mvn spring-boot:run
```

### Initialisering av database med arter og bilder (med curl)
Sett inn ønsket e-post og passord:

```sh
curl -v --header "Content-Type: application/json" --request POST --data '{"email": "epost", "password": "passord"}' http://localhost:8080/users
```

```sh
curl -v --header "Content-Type: application/json" --request POST --data '{"email": "epost", "password": "passord"}' http://localhost:8080/login
```

Bytt ut ordet token med den du mottok etter forrige request

```sh
curl -H "Authorization: Bearer token" -H "Content-Type: application/json" -v --request POST --data '[
  {
    "id": "25",
    "norsknavn": "ametystsopp",
    "latinsknavn": "Laccaria amethystina",
    "normstatus": "ikke matsopp",
    "kommentar": null
  },
  {
    "id": "1",
    "norsknavn": "beitesjampinjong-gruppen",
    "latinsknavn": "Agaricus seksjon Agaricus",
    "normstatus": "spiselig",
    "kommentar": null
  },
  {
    "id": "63",
    "norsknavn": "hvit sprøsopp",
    "latinsknavn": "Psathyrella candolleana",
    "normstatus": "spiselig",
    "kommentar": null
  },
  {
    "id": "135",
    "norsknavn": "svartringfluesopp",
    "latinsknavn": "Amanita porphyria",
    "normstatus": "ikke matsopp",
    "kommentar": null
  },
  {
    "id": "43",
    "norsknavn": "granmatriske",
    "latinsknavn": "Lactarius deterrimus",
    "normstatus": "spiselig",
    "kommentar": null
  },
  {
    "id": "27",
    "norsknavn": "engvokssopp-gruppen",
    "latinsknavn": "Cuphophyllus pratensis coll.",
    "normstatus": "spiselig",
    "kommentar": null
  },
  {
    "id": "64",
    "norsknavn": "ildrørsopp",
    "latinsknavn": "Suillellus luridus",
    "normstatus": "spiselig med merknad",
    "kommentar": "Giftig som rå. Krever varmebehandling i minst 15 minutter ved middels til høy temperatur."
  },
  {
    "id": "120",
    "norsknavn": "skarp gulkremle",
    "latinsknavn": "Russula ochroleuca",
    "normstatus": "spiselig",
    "kommentar": null
  },
  {
    "id": "114",
    "norsknavn": "rødnende fluesopp",
    "latinsknavn": "Amanita rubescens",
    "normstatus": "spiselig med merknad",
    "kommentar": "Giftig som rå. Krever varmebehandling i minst 15 minutter ved middels til høy temperatur."
  },
  {
    "id": "117",
    "norsknavn": "sandmorkel",
    "latinsknavn": "Gyromitra esculenta",
    "normstatus": "giftig",
    "kommentar": null
  },
  {
    "id": "111",
    "norsknavn": "rødbrun steinsopp",
    "latinsknavn": "Boletus pinophilus",
    "normstatus": "spiselig",
    "kommentar": null
  },
  {
    "id": "98",
    "norsknavn": "potetrøyksopper",
    "latinsknavn": "Scleroderma spp",
    "normstatus": "giftig",
    "kommentar": null
  },
  {
    "id": "14",
    "norsknavn": "blågrå østerssopp",
    "latinsknavn": "Pleurotus ostreatus",
    "normstatus": "spiselig",
    "kommentar": null
  },
  {
    "id": "108",
    "norsknavn": "rød stubbemusserong",
    "latinsknavn": "Tricholomopsis rutilans",
    "normstatus": "ikke matsopp",
    "kommentar": null
  },
  {
    "id": "134",
    "norsknavn": "svartbrun rørsopp",
    "latinsknavn": "Imleria badia",
    "normstatus": "spiselig",
    "kommentar": null
  },
  {
    "id": "94",
    "norsknavn": "pantermusserong",
    "latinsknavn": "Tricholoma filamentosum",
    "normstatus": "giftig",
    "kommentar": null
  },
  {
    "id": "65",
    "norsknavn": "irrgrønn kragesopp",
    "latinsknavn": "Stropharia aeruginosa",
    "normstatus": "spiselig",
    "kommentar": null
  },
  {
    "id": "58",
    "norsknavn": "honningsopper",
    "latinsknavn": "Armillaria spp.",
    "normstatus": "ikke matsopp",
    "kommentar": null
  },
  {
    "id": "31",
    "norsknavn": "fløyelspluggsopp",
    "latinsknavn": "Tapinella atrotomentosa",
    "normstatus": "ikke matsopp",
    "kommentar": null
  },
  {
    "id": "110",
    "norsknavn": "rødbrun pepperriske",
    "latinsknavn": "Lactarius rufus",
    "normstatus": "spiselig med merknad",
    "kommentar": "Spiselig etter avkoking."
  },
  {
    "id": "10",
    "norsknavn": "blodsjampinjong-gruppen",
    "latinsknavn": "Agaricus seksjon Sanguinolenti",
    "normstatus": "spiselig",
    "kommentar": null
  },
  {
    "id": "78",
    "norsknavn": "lakssopp",
    "latinsknavn": "Laccaria laccata",
    "normstatus": "spiselig",
    "kommentar": null
  },
  {
    "id": "56",
    "norsknavn": "gulrød kremle",
    "latinsknavn": "Russula decolorans",
    "normstatus": "spiselig",
    "kommentar": null
  },
  {
    "id": "133",
    "norsknavn": "svart trompetsopp",
    "latinsknavn": "Craterellus cornucopioides",
    "normstatus": "spiselig",
    "kommentar": null
  },
  {
    "id": "139",
    "norsknavn": "såpemusserong",
    "latinsknavn": "Tricholoma saponaceum",
    "normstatus": "ikke matsopp",
    "kommentar": null
  },
  {
    "id": "8",
    "norsknavn": "blek piggsopp",
    "latinsknavn": "Hydnum repandum",
    "normstatus": "spiselig",
    "kommentar": null
  },
  {
    "id": "26",
    "norsknavn": "eggrøyksopper",
    "latinsknavn": "Bovista spp.",
    "normstatus": "spiselig",
    "kommentar": null
  },
  {
    "id": "74",
    "norsknavn": "korallsopper",
    "latinsknavn": "Ramaria spp.",
    "normstatus": "ikke matsopp",
    "kommentar": null
  },
  {
    "id": "106",
    "norsknavn": "ringløs smørsopp",
    "latinsknavn": "Suillus granulatus",
    "normstatus": "spiselig",
    "kommentar": null
  },
  {
    "id": "115",
    "norsknavn": "silkemusserong",
    "latinsknavn": "Tricholoma columbetta",
    "normstatus": "spiselig",
    "kommentar": null
  },
  {
    "id": "82",
    "norsknavn": "mandelriske",
    "latinsknavn": "Lactifluus volemus",
    "normstatus": "spiselig",
    "kommentar": null
  },
  {
    "id": "5",
    "norsknavn": "bittersopper",
    "latinsknavn": "Gymnopilus spp.",
    "normstatus": "ikke matsopp",
    "kommentar": null
  },
  {
    "id": "12",
    "norsknavn": "blå ridderhatt",
    "latinsknavn": "Lepista nuda",
    "normstatus": "spiselig",
    "kommentar": null
  },
  {
    "id": "61",
    "norsknavn": "hvit knippesopp",
    "latinsknavn": "Leucocybe connata",
    "normstatus": "ikke matsopp",
    "kommentar": null
  },
  {
    "id": "84",
    "norsknavn": "rødgul piggsopp",
    "latinsknavn": "Hydnum rufescens",
    "normstatus": "spiselig",
    "kommentar": null
  },
  {
    "id": "144",
    "norsknavn": "vårfagerhatt",
    "latinsknavn": "Calocybe gambosa",
    "normstatus": "spiselig",
    "kommentar": null
  },
  {
    "id": "46",
    "norsknavn": "grønnkremle",
    "latinsknavn": "Russula aeruginea",
    "normstatus": "spiselig",
    "kommentar": null
  },
  {
    "id": "132",
    "norsknavn": "stubbeskjellsopp",
    "latinsknavn": "Kuehneromyces mutabilis",
    "normstatus": "spiselig",
    "kommentar": null
  },
  {
    "id": "17",
    "norsknavn": "brungul stubbemusserong",
    "latinsknavn": "Tricholomopsis decora",
    "normstatus": "ikke matsopp",
    "kommentar": null
  },
  {
    "id": "49",
    "norsknavn": "grå jordmusserong",
    "latinsknavn": "Tricholoma terreum",
    "normstatus": "spiselig",
    "kommentar": null
  },
  {
    "id": "24",
    "norsknavn": "spiss giftslørsopp",
    "latinsknavn": "Cortinarius rubellus",
    "normstatus": "meget giftig",
    "kommentar": null
  },
  {
    "id": "143",
    "norsknavn": "vintersopp",
    "latinsknavn": "Flammulina spp.",
    "normstatus": "spiselig",
    "kommentar": null
  },
  {
    "id": "72",
    "norsknavn": "klubbetraktsopp",
    "latinsknavn": "Ampulloclitocybe clavipes",
    "normstatus": "ikke matsopp",
    "kommentar": null
  },
  {
    "id": "60",
    "norsknavn": "hvit fluesopp",
    "latinsknavn": "Amanita virosa",
    "normstatus": "meget giftig",
    "kommentar": null
  },
  {
    "id": "119",
    "norsknavn": "seig kusopp",
    "latinsknavn": "Suillus bovinus",
    "normstatus": "spiselig",
    "kommentar": null
  },
  {
    "id": "2",
    "norsknavn": "besk rørsopp",
    "latinsknavn": "Caloboletus calopus",
    "normstatus": "ikke matsopp",
    "kommentar": null
  },
  {
    "id": "57",
    "norsknavn": "heggetraktsopp",
    "latinsknavn": "Infundibulicybe geotropa",
    "normstatus": "spiselig",
    "kommentar": null
  },
  {
    "id": "87",
    "norsknavn": "mørk høstmorkel",
    "latinsknavn": "Helvella lacunosa",
    "normstatus": "spiselig",
    "kommentar": null
  },
  {
    "id": "71",
    "norsknavn": "klubbesopper",
    "latinsknavn": "Clavariadelphus spp.",
    "normstatus": "spiselig",
    "kommentar": null
  },
  {
    "id": "9",
    "norsknavn": "blodrørsopp",
    "latinsknavn": "Neoboletus praestigiator",
    "normstatus": "spiselig med merknad",
    "kommentar": "Giftig som rå. Krever varmebehandling i minst 15 minutter ved middels til høy temperatur."
  },
  {
    "id": "80",
    "norsknavn": "lodden hvitriske",
    "latinsknavn": "Lactifluus vellereus",
    "normstatus": "spiselig med merknad",
    "kommentar": "Spiselig etter avkoking."
  },
  {
    "id": "121",
    "norsknavn": "skjeggriske",
    "latinsknavn": "Lactarius torminosus",
    "normstatus": "spiselig med merknad",
    "kommentar": "Spiselig etter avkoking."
  },
  {
    "id": "62",
    "norsknavn": "hvit pepperriske",
    "latinsknavn": "Lactifluus piperatus",
    "normstatus": "spiselig med merknad",
    "kommentar": "Spiselig etter avkoking."
  },
  {
    "id": "41",
    "norsknavn": "giftparasollsopp",
    "latinsknavn": "Lepiota brunneoincarnata",
    "normstatus": "meget giftig",
    "kommentar": null
  },
  {
    "id": "36",
    "norsknavn": "furumatriske",
    "latinsknavn": "Lactarius deliciosus",
    "normstatus": "spiselig",
    "kommentar": null
  },
  {
    "id": "68",
    "norsknavn": "kantarell",
    "latinsknavn": "Cantharellus cibarius",
    "normstatus": "spiselig",
    "kommentar": null
  },
  {
    "id": "113",
    "norsknavn": "rødkremle",
    "latinsknavn": "Russula emetica",
    "normstatus": "ikke matsopp",
    "kommentar": null
  },
  {
    "id": "21",
    "norsknavn": "gallerørsopp",
    "latinsknavn": "Tylopilus felleus",
    "normstatus": "ikke matsopp",
    "kommentar": null
  },
  {
    "id": "126",
    "norsknavn": "sommermunkehatt",
    "latinsknavn": "Melanoleuca strictipes",
    "normstatus": "ikke matsopp",
    "kommentar": null
  },
  {
    "id": "131",
    "norsknavn": "stor kragesopp",
    "latinsknavn": "Stropharia hornemannii",
    "normstatus": "spiselig",
    "kommentar": null
  },
  {
    "id": "30",
    "norsknavn": "flatklokkehatt",
    "latinsknavn": "Galerina marginata",
    "normstatus": "meget giftig",
    "kommentar": null
  },
  {
    "id": "142",
    "norsknavn": "tægersopp",
    "latinsknavn": "Clitocybula platyphylla",
    "normstatus": "ikke matsopp",
    "kommentar": null
  },
  {
    "id": "88",
    "norsknavn": "nelliksopp",
    "latinsknavn": "Marasmius oreades",
    "normstatus": "spiselig",
    "kommentar": null
  },
  {
    "id": "35",
    "norsknavn": "furuknippesopp",
    "latinsknavn": "Lyophyllum shimeji",
    "normstatus": "spiselig",
    "kommentar": null
  },
  {
    "id": "67",
    "norsknavn": "kamfluesopp-gruppen",
    "latinsknavn": "Amanita vaginatae m.fl.",
    "normstatus": "spiselig med merknad",
    "kommentar": "Giftig som rå. Krever varmebehandling i minst 15 minutter ved middels til høy temperatur."
  },
  {
    "id": "73",
    "norsknavn": "kongesjampinjong",
    "latinsknavn": "Agaricus augustus",
    "normstatus": "spiselig",
    "kommentar": null
  },
  {
    "id": "138",
    "norsknavn": "svovelsopp",
    "latinsknavn": "Hypholoma capnoides",
    "normstatus": "spiselig",
    "kommentar": null
  },
  {
    "id": "96",
    "norsknavn": "pepperrørsopp",
    "latinsknavn": "Chalciporus piperatus",
    "normstatus": "spiselig med merknad",
    "kommentar": "Kan gi mage-/tarmreaksjon ved større inntak. Egner seg best som smakstilsetning."
  },
  {
    "id": "146",
    "norsknavn": "våråkersopp",
    "latinsknavn": "Agrocybe praecox",
    "normstatus": "spiselig",
    "kommentar": null
  },
  {
    "id": "125",
    "norsknavn": "smørsopp",
    "latinsknavn": "Suillus luteus",
    "normstatus": "spiselig",
    "kommentar": null
  },
  {
    "id": "145",
    "norsknavn": "vårtrevlesopp",
    "latinsknavn": "Inosperma erubescens",
    "normstatus": "giftig",
    "kommentar": null
  },
  {
    "id": "33",
    "norsknavn": "franskbrødsopp",
    "latinsknavn": "Albatrellus confluens",
    "normstatus": "spiselig",
    "kommentar": null
  },
  {
    "id": "19",
    "norsknavn": "brunskrubb",
    "latinsknavn": "Leccinum scabrum",
    "normstatus": "spiselig",
    "kommentar": null
  },
  {
    "id": "101",
    "norsknavn": "raspskjellsopp",
    "latinsknavn": "Pholiota squarrosa",
    "normstatus": "ikke matsopp",
    "kommentar": null
  },
  {
    "id": "128",
    "norsknavn": "sotvokssopp",
    "latinsknavn": "Hygrophorus camarophyllus",
    "normstatus": "spiselig",
    "kommentar": null
  },
  {
    "id": "45",
    "norsknavn": "grønn fluesopp",
    "latinsknavn": "Amanita phalloides",
    "normstatus": "meget giftig",
    "kommentar": null
  },
  {
    "id": "53",
    "norsknavn": "kjeglevokssopp-gruppen",
    "latinsknavn": "Hygrocybe conica coll.",
    "normstatus": "ikke matsopp",
    "kommentar": null
  },
  {
    "id": "118",
    "norsknavn": "sandsopp",
    "latinsknavn": "Suillus variegatus",
    "normstatus": "spiselig",
    "kommentar": null
  },
  {
    "id": "85",
    "norsknavn": "melsopp",
    "latinsknavn": "Clitopilus prunulus",
    "normstatus": "spiselig",
    "kommentar": null
  },
  {
    "id": "127",
    "norsknavn": "sotriske",
    "latinsknavn": "Lactarius lignyotus",
    "normstatus": "spiselig",
    "kommentar": null
  },
  {
    "id": "103",
    "norsknavn": "reddiksopper",
    "latinsknavn": "Hebeloma spp.",
    "normstatus": "giftig",
    "kommentar": null
  },
  {
    "id": "51",
    "norsknavn": "gråmusserong",
    "latinsknavn": "Tricholoma portentosum",
    "normstatus": "spiselig",
    "kommentar": null
  },
  {
    "id": "28",
    "norsknavn": "falsk kantarell",
    "latinsknavn": "Hygrophoropsis aurantiaca",
    "normstatus": "ikke matsopp",
    "kommentar": null
  },
  {
    "id": "3",
    "norsknavn": "besk svovelsopp",
    "latinsknavn": "Hypholoma fasciculare",
    "normstatus": "giftig",
    "kommentar": null
  },
  {
    "id": "91",
    "norsknavn": "oransjebeger",
    "latinsknavn": "Aleuria aurantia",
    "normstatus": "spiselig",
    "kommentar": null
  },
  {
    "id": "130",
    "norsknavn": "stankkremle",
    "latinsknavn": "Russula foetens",
    "normstatus": "ikke matsopp",
    "kommentar": null
  },
  {
    "id": "7",
    "norsknavn": "bjørkeøsterssopp",
    "latinsknavn": "Pleurotus pulmonarius",
    "normstatus": "spiselig",
    "kommentar": null
  },
  {
    "id": "34",
    "norsknavn": "frostvokssopp",
    "latinsknavn": "Hygrophorus hypothejus",
    "normstatus": "spiselig",
    "kommentar": null
  },
  {
    "id": "37",
    "norsknavn": "furuskjellpigg",
    "latinsknavn": "Sarcodon squamosus",
    "normstatus": "spiselig",
    "kommentar": null
  },
  {
    "id": "107",
    "norsknavn": "rød fluesopp",
    "latinsknavn": "Amanita muscaria",
    "normstatus": "giftig",
    "kommentar": null
  },
  {
    "id": "66",
    "norsknavn": "judasøre",
    "latinsknavn": "Auricularia auricula-judae",
    "normstatus": "spiselig",
    "kommentar": null
  },
  {
    "id": "22",
    "norsknavn": "rødskrubb",
    "latinsknavn": "Leccinum versipelle",
    "normstatus": "spiselig med merknad",
    "kommentar": "Giftig som rå. Krever varmebehandling i minst 15 minutter ved middels til høy temperatur."
  },
  {
    "id": "69",
    "norsknavn": "kjemperøyksopp",
    "latinsknavn": "Langermannia gigantea",
    "normstatus": "spiselig",
    "kommentar": null
  },
  {
    "id": "48",
    "norsknavn": "grå fluesopp",
    "latinsknavn": "Amanita excelsa",
    "normstatus": "spiselig",
    "kommentar": null
  },
  {
    "id": "32",
    "norsknavn": "fløyelsrørsopp",
    "latinsknavn": "Xerocomus ferrugineus",
    "normstatus": "spiselig",
    "kommentar": null
  },
  {
    "id": "122",
    "norsknavn": "skjermsopp",
    "latinsknavn": "Pluteus cervinus",
    "normstatus": "spiselig",
    "kommentar": null
  },
  {
    "id": "83",
    "norsknavn": "matblekksopp",
    "latinsknavn": "Coprinus comatus",
    "normstatus": "spiselig",
    "kommentar": null
  },
  {
    "id": "29",
    "norsknavn": "fiolett svovelriske",
    "latinsknavn": "Lactarius repraesentaneus",
    "normstatus": "spiselig med merknad",
    "kommentar": "Spiselig etter avkoking."
  },
  {
    "id": "124",
    "norsknavn": "sliresopper",
    "latinsknavn": "Volvariella spp.",
    "normstatus": "spiselig",
    "kommentar": null
  },
  {
    "id": "93",
    "norsknavn": "panterfluesopp",
    "latinsknavn": "Amanita pantherina",
    "normstatus": "giftig",
    "kommentar": null
  },
  {
    "id": "77",
    "norsknavn": "lakrisriske",
    "latinsknavn": "Lactarius helvus",
    "normstatus": "giftig",
    "kommentar": null
  },
  {
    "id": "52",
    "norsknavn": "gul fluesopp",
    "latinsknavn": "Amanita citrina",
    "normstatus": "ikke matsopp",
    "kommentar": null
  },
  {
    "id": "15",
    "norsknavn": "blåkjøttbukkesopp",
    "latinsknavn": "Cortinarius camphoratus",
    "normstatus": "ikke matsopp",
    "kommentar": null
  },
  {
    "id": "76",
    "norsknavn": "krittøsterssopp",
    "latinsknavn": "Pleurocybella porrigens",
    "normstatus": "spiselig med merknad",
    "kommentar": "Bør unngås ved nedsatt nyrefunksjon."
  },
  {
    "id": "40",
    "norsknavn": "giftrødspore",
    "latinsknavn": "Entoloma sinuatum",
    "normstatus": "giftig",
    "kommentar": null
  },
  {
    "id": "92",
    "norsknavn": "oransjeslørsopp",
    "latinsknavn": "Cortinarius limonius",
    "normstatus": "ikke matsopp",
    "kommentar": null
  },
  {
    "id": "54",
    "norsknavn": "gul trompetsopp",
    "latinsknavn": "Craterellus lutescens",
    "normstatus": "spiselig",
    "kommentar": null
  },
  {
    "id": "50",
    "norsknavn": "grå knippesopp",
    "latinsknavn": "Lyophyllum decastes",
    "normstatus": "spiselig",
    "kommentar": null
  },
  {
    "id": "104",
    "norsknavn": "riddermusserong",
    "latinsknavn": "Tricholoma equestre",
    "normstatus": "giftig",
    "kommentar": null
  },
  {
    "id": "140",
    "norsknavn": "traktkantarell",
    "latinsknavn": "Craterellus tubaeformis",
    "normstatus": "spiselig",
    "kommentar": null
  },
  {
    "id": "90",
    "norsknavn": "olivenbrun vokssopp",
    "latinsknavn": "Hygrophorus olivaceoalbus",
    "normstatus": "spiselig",
    "kommentar": null
  },
  {
    "id": "44",
    "norsknavn": "granskjellpigg",
    "latinsknavn": "Sarcodon imbricatus",
    "normstatus": "spiselig",
    "kommentar": null
  },
  {
    "id": "38",
    "norsknavn": "fåresopp",
    "latinsknavn": "Albatrellus ovinus",
    "normstatus": "spiselig",
    "kommentar": null
  },
  {
    "id": "11",
    "norsknavn": "blomkålsopp",
    "latinsknavn": "Sparassis crispa",
    "normstatus": "spiselig",
    "kommentar": null
  },
  {
    "id": "59",
    "norsknavn": "hulriske",
    "latinsknavn": "Lactarius trivialis",
    "normstatus": "spiselig med merknad",
    "kommentar": "Spiselig etter avkoking."
  },
  {
    "id": "20",
    "norsknavn": "steinsopp",
    "latinsknavn": "Boletus edulis",
    "normstatus": "spiselig",
    "kommentar": null
  },
  {
    "id": "95",
    "norsknavn": "rødnende parasollsopp",
    "latinsknavn": "Chlorophyllum rhacodes",
    "normstatus": "spiselig",
    "kommentar": null
  },
  {
    "id": "86",
    "norsknavn": "mild gulkremle",
    "latinsknavn": "Russula claroflava",
    "normstatus": "spiselig",
    "kommentar": null
  },
  {
    "id": "4",
    "norsknavn": "bispelue",
    "latinsknavn": "Gyromitra infula",
    "normstatus": "spiselig med merknad",
    "kommentar": "Skal avvises på soppkontroll fordi den bare kan skilles fra den giftige narrelue (Gyromitra ambigua) med mikroskop"
  },
  {
    "id": "100",
    "norsknavn": "rabarbrasopp-gruppen",
    "latinsknavn": "Chroogomphus rutilus coll.",
    "normstatus": "spiselig",
    "kommentar": null
  },
  {
    "id": "129",
    "norsknavn": "spissmorkel",
    "latinsknavn": "Morchella conica",
    "normstatus": "spiselig med merknad",
    "kommentar": "Lett forgiftning er rapportert etter store eller lite varmebehandlede måltider."
  },
  {
    "id": "23",
    "norsknavn": "butt giftslørsopp",
    "latinsknavn": "Cortinarius orellanus",
    "normstatus": "meget giftig",
    "kommentar": null
  },
  {
    "id": "99",
    "norsknavn": "puddertraktsopp",
    "latinsknavn": "Clitocybe nebularis",
    "normstatus": "spiselig",
    "kommentar": null
  },
  {
    "id": "136",
    "norsknavn": "svartriske",
    "latinsknavn": "Lactarius necator",
    "normstatus": "ikke matsopp",
    "kommentar": null
  },
  {
    "id": "70",
    "norsknavn": "kjempetraktmusserong",
    "latinsknavn": "Aspropaxillus giganteus",
    "normstatus": "spiselig",
    "kommentar": null
  },
  {
    "id": "42",
    "norsknavn": "giftsjampinjong-gruppen",
    "latinsknavn": "Agaricus xanthodermus",
    "normstatus": "giftig",
    "kommentar": null
  },
  {
    "id": "147",
    "norsknavn": "åkersjampinjong-gruppen",
    "latinsknavn": "Agaricus seksjon Arvenses",
    "normstatus": "spiselig",
    "kommentar": null
  },
  {
    "id": "16",
    "norsknavn": "brun fluesopp",
    "latinsknavn": "Amanita regalis",
    "normstatus": "giftig",
    "kommentar": null
  },
  {
    "id": "55",
    "norsknavn": "gullskjellsopp",
    "latinsknavn": "Phaeolepiota aurea",
    "normstatus": "spiselig med merknad",
    "kommentar": "Kan gi mage-/tarmreaksjon. Kun unge eksemplarer brukes og skal varmebehandles samme dag."
  },
  {
    "id": "148",
    "norsknavn": "svartskrubb",
    "latinsknavn": "Leccinum variicolor",
    "normstatus": "spiselig med merknad",
    "kommentar": "Giftig som rå. Krever varmebehandling i minst 15 minutter ved middels til høy temperatur."
  },
  {
    "id": "6",
    "norsknavn": "bjørkemusserong",
    "latinsknavn": "Tricholoma fulvum",
    "normstatus": "spiselig",
    "kommentar": null
  },
  {
    "id": "18",
    "norsknavn": "brunkjøttbukkesopp",
    "latinsknavn": "Cortinarius traganus",
    "normstatus": "ikke matsopp",
    "kommentar": null
  },
  {
    "id": "105",
    "norsknavn": "rimsopp",
    "latinsknavn": "Cortinarius caperatus",
    "normstatus": "spiselig",
    "kommentar": null
  },
  {
    "id": "81",
    "norsknavn": "lumsk traktsopp",
    "latinsknavn": "Clitocybe rivulosa",
    "normstatus": "giftig",
    "kommentar": null
  },
  {
    "id": "75",
    "norsknavn": "kransmusserong",
    "latinsknavn": "Tricholoma matsutake",
    "normstatus": "spiselig",
    "kommentar": null
  },
  {
    "id": "123",
    "norsknavn": "sleipsopp",
    "latinsknavn": "Gomphidius glutinosus",
    "normstatus": "spiselig",
    "kommentar": null
  },
  {
    "id": "97",
    "norsknavn": "pluggsopp",
    "latinsknavn": "Paxillus involutus",
    "normstatus": "giftig",
    "kommentar": null
  },
  {
    "id": "47",
    "norsknavn": "grå blekksopp",
    "latinsknavn": "Coprinopsis atramentaria",
    "normstatus": "ikke matsopp",
    "kommentar": null
  },
  {
    "id": "141",
    "norsknavn": "turkistraktkremle",
    "latinsknavn": "Russula chloroides",
    "normstatus": "spiselig",
    "kommentar": null
  },
  {
    "id": "109",
    "norsknavn": "rødbelteslørsopp",
    "latinsknavn": "Cortinarius armillatus",
    "normstatus": "ikke matsopp",
    "kommentar": null
  },
  {
    "id": "112",
    "norsknavn": "rødflekkvokssopp",
    "latinsknavn": "Hygrophorus erubescens",
    "normstatus": "ikke matsopp",
    "kommentar": null
  },
  {
    "id": "116",
    "norsknavn": "skarlagenvokssopp",
    "latinsknavn": "Hygrocybe punicea",
    "normstatus": "spiselig",
    "kommentar": null
  },
  {
    "id": "13",
    "norsknavn": "duftvokssopp",
    "latinsknavn": "Hygrophorus agathosmus",
    "normstatus": "spiselig",
    "kommentar": null
  },
  {
    "id": "39",
    "norsknavn": "gallemusserong",
    "latinsknavn": "Tricholoma virgatum",
    "normstatus": "ikke matsopp",
    "kommentar": null
  },
  {
    "id": "79",
    "norsknavn": "lerkesopp",
    "latinsknavn": "Suillus grevillei",
    "normstatus": "spiselig",
    "kommentar": null
  },
  {
    "id": "137",
    "norsknavn": "svovelriske",
    "latinsknavn": "Lactarius scrobiculatus",
    "normstatus": "spiselig med merknad",
    "kommentar": "Spiselig etter avkoking."
  },
  {
    "id": "89",
    "norsknavn": "nøttekremle",
    "latinsknavn": "Russula vesca",
    "normstatus": "spiselig",
    "kommentar": null
  },
  {
    "id": "102",
    "norsknavn": "reddikmusserong",
    "latinsknavn": "Tricholoma stiparophyllum",
    "normstatus": "giftig",
    "kommentar": null
  }
]' localhost:8080/add_species_json
```

Husk å sette inn token her også:

```sh
curl -H "Authorization: Bearer token" -v --request GET http://localhost:8080/update_species_pictures
```
