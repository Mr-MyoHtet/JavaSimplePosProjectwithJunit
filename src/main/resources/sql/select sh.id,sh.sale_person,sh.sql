select sh.id,sh.sale_person,sh.sale_at,sum(ps.quantity) itemCount,sum(sp.unit_price * sp.quantity) totalAmount
from SALE_HISTORY sh join SALE_PRODUCT sp on sh.id = sp.sale_id where %s group by sh.id,sh.sale_person,sh.sale_at


select sp.sale_id id,sp.code productCode,p.name productName,sp.unit_price,sp.quantity from SALE_PRODUCT sp join
SALE_HISTORY sh on sp.sale_id = sh.id join PRODUCT p on p.code =sp.code where sp.sale_id = :saldeId order
by sp.code