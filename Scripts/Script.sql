select m.message_id, m.text, s.name, s.subscriber_id
from message m join subscriber s 
using (subscriber_id)
where forum_id= 1;