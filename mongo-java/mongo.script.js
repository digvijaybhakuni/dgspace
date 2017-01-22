
db.grades.aggregate( { '$group' : { '_id' : '$student_id', 'average' : { $avg : '$score' } } }, { '$sort' : { 'average' : -1 } }, { '$limit' : 1 } )

db.grades.aggregate({'$group': {'_id': '$student_id', 'lowest': {$min: '$score'} }});

db.grades.find({"type":"homework"}).sort({"student_id":1},{"score":1});

db.grades.find( { }, { 'student_id' : 1, 'type' : 1, 'score' : 1, '_id' : 0 } ).sort( { 'student_id' : 1, 'score' : 1, } ).limit( 5 );


db.grades.aggregate( { '$group' : { '_id' : '$student_id', 'average' : { $avg : '$score' } } }, { '$sort' : { 'average' : -1 } }, { '$limit' : 1 } );

db.movieDetails.find({year: 2013, rated: 'PG-13', 'award.win': {$gt: 0}});

db.movieDetails.find({'countries.1': 'Sweden'}, {countries: 1});