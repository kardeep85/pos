//@CrossOrigin(origins = "http://localhost:3000")

//Local
CREATE KEYSPACE store
WITH replication = {'class':'SimpleStrategy', 'replication_factor' : 1};

//Datacenter
CREATE KEYSPACE store
WITH replication = {'class':'NetworkTopologyStrategy', 'CDC' : 1};




CREATE TABLE store.sale_id (
    transactionNo text,
     itemId text,
     quantity double,
     description text,
     price double,
     totalPrice double,
     PRIMARY KEY ((transactionNo), itemId),
) WITH bloom_filter_fp_chance = 0.01
    AND comment = ''
    AND compaction = {'min_threshold': '4', 'class': 'org.apache.cassandra.db.compaction.SizeTieredCompactionStrategy', 'max_threshold': '32'}
    AND compression = {'sstable_compression': 'org.apache.cassandra.io.compress.LZ4Compressor'}
    AND default_time_to_live = 0
    AND gc_grace_seconds = 864000
    AND max_index_interval = 2048
    AND memtable_flush_period_in_ms = 0
    AND min_index_interval = 128
    AND read_repair_chance = 0.0
    AND speculative_retry = '99.0PERCENTILE';


CREATE TABLE store.transaction_id (
    transactionNo text PRIMARY KEY,
     status text,
     total double,
     customerId text,
     customerContact text,
     paid double,
     balance double,
     modeOfPayment text,
     customerTransactionNo text,
) WITH bloom_filter_fp_chance = 0.01
    AND comment = ''
    AND compaction = {'min_threshold': '4', 'class': 'org.apache.cassandra.db.compaction.SizeTieredCompactionStrategy', 'max_threshold': '32'}
    AND compression = {'sstable_compression': 'org.apache.cassandra.io.compress.LZ4Compressor'}
    AND default_time_to_live = 0
    AND gc_grace_seconds = 864000
    AND max_index_interval = 2048
    AND memtable_flush_period_in_ms = 0
    AND min_index_interval = 128
    AND read_repair_chance = 0.0
    AND speculative_retry = '99.0PERCENTILE';



