select f.name, f.description, s.name
from forum f
join "subscription" sn
using (forum_id)
join subscriber s 
using (subscriber_id);

select s.name, m.text, f.name 
from forum f
join message m 
using (forum_id)
join subscriber s 
using (subscriber_id);

select f.forum_id, f.name, f.description 
from forum f join "subscription" s 
using (forum_id)
where s.subscriber_id = 1;

/*select f.forum_id, f.name, f.description, s.subscriber_id 
from forum f left outer join "subscription" s 
on (forum_id)
where s.subscriber_id != 1;*/

select m.message_id, m.text, m.creation, m.subscriber_id, s.name
from message m join subscriber s
using (subscriber_id)
where forum_id = 1;